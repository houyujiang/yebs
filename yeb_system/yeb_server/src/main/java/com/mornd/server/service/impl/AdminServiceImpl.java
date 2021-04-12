package com.mornd.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mornd.server.config.security.component.JWTTokenUtil;
import com.mornd.server.mapper.AdminMapper;
import com.mornd.server.pojo.*;
import com.mornd.server.service.AdminService;
import com.mornd.server.utils.CaptchaUtil;
import com.mornd.server.vo.AdminVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author mornd
 * @date 2021/1/26 - 22:12
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Resource
    private UserDetailsService userDetailsService;
    //密码加解密对象
    @Resource
    private PasswordEncoder passwordEncoder;
    //token工具类
    @Resource
    private JWTTokenUtil jwtTokenUtil;
    //token的头部信息
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 用户登录之后返回token
     *
     * @param adminLoginParam
     * @param request
     * @return
     */
    @Override
    public RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(ObjectUtils.isEmpty(session)){
            return RespBean.error("session不能为空");
        }
        //比较验证码
        if (!CaptchaUtil.ver(adminLoginParam.getCode(), request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            return RespBean.error("验证码错误，请重新输入");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(adminLoginParam.getUsername());
        if(ObjectUtils.isEmpty(userDetails)){
            return RespBean.error("用户名不存在");
        }
        if(!passwordEncoder.matches(adminLoginParam.getPassword(),userDetails.getPassword())){
            return RespBean.error("密码错误");
        }
        if(!userDetails.isEnabled()){
            return RespBean.error("该账号已被禁用");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        //将用户登录信息放入security上下文对象中
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,Object> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        log.info("登录成功，当前登录用户：{}",userDetails.getUsername());
        return RespBean.success("登录成功！",tokenMap);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public Admin getAdminByUsername(String username) {
        return super.baseMapper.selectOne(new QueryWrapper<Admin>()
        .eq("username",username));
    }

    /**
     * 根据用户id查询角色列表
     *
     * @param adminId
     * @return
     */
    @Override
    public Set<Role> getRoles(Integer adminId) {
        return super.baseMapper.getRoles(adminId);
    }

    /**
     * 获取所有操作员(不包括当前登录的)
     *
     * @param adminVo
     * @return
     */
    @Override
    public IPage<Admin> getAllAdmins(AdminVo adminVo) {
        IPage<Admin> page = new Page<>(adminVo.getPage(),adminVo.getSize());
        //当前登录用户
        Admin principal = (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        adminVo.setId(principal.getId());
        //查询条件
        return baseMapper.getAllAdminExCurrent(page,adminVo);
        /*QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtils.isEmpty(adminVo.getName()),"name",adminVo.getName());
        wrapper.like(!ObjectUtils.isEmpty(adminVo.getUsername()),"username",adminVo.getUsername());
        wrapper.notIn("id",principal.getId());
        return super.page(page,wrapper);*/
    }

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    @Override
    public RespBean updateAdminRole(Integer adminId, Integer[] rids) {
        baseMapper.removeRoleByAid(adminId);
        if(ObjectUtils.isEmpty(rids) ||
                baseMapper.addAdminRole(adminId,rids).equals(rids.length)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 更新用户密码
     *
     * @param oldPassword
     * @param password
     * @param adminId
     * @return
     */
    @Override
    public RespBean updateAdminPassword(String oldPassword, String password, Integer adminId) {
        //根据老密码获取用户对象
        Admin admin = baseMapper.selectById(adminId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //判断老密码是否正确
        if(encoder.matches(oldPassword,admin.getPassword())){
            admin.setPassword(encoder.encode(password));
            //执行修改
            if(Integer.valueOf(1).equals(baseMapper.updateById(admin))){
                return RespBean.success("密码更新成功！");
            }
            return RespBean.error("密码更新失败！");
        }
        return RespBean.error("原密码不正确！");
    }

    /**
     * 删除操作员及操作员角色关系表中的数据
     * @param id
     * @return
     */
    @Override
    public boolean removeById(Serializable id) {
        baseMapper.removeRoleByAid(id);
        return super.removeById(id);
    }
}
