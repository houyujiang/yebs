package com.mornd.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mornd.server.pojo.*;
import com.mornd.server.vo.AdminVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author mornd
 * @date 2021/1/26 - 22:11
 */
public interface AdminService extends IService<Admin> {
    /**
     * 用户登录之后返回token
     * @param adminLoginParam
     * @param request
     * @return
     */
    RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);

    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    Set<Role> getRoles(Integer adminId);

    /**
     * 获取所有操作员(不包括当前登录的)
     * @param adminVo
     * @return
     */
    IPage<Admin> getAllAdmins(AdminVo adminVo);

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);

    /**
     * 更新用户密码
     * @param oldPassword
     * @param password
     * @param adminId
     * @return
     */
    RespBean updateAdminPassword(String oldPassword, String password, Integer adminId);
}
