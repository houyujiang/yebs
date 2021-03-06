package com.mornd.server.controller;

import com.mornd.server.pojo.Admin;
import com.mornd.server.pojo.RespBean;
import com.mornd.server.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author mornd
 * @date 2021/2/28 - 15:48
 * 个人中心
 */
@RestController
public class AdminInfoController {
    @Resource
    private AdminService adminService;

    @ApiOperation("更新当前用户信息")
    @PutMapping("/admin/info")
    public RespBean updateAdmin(@RequestBody Admin admin, Authentication authentication){
        if(adminService.updateById(admin)){
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(admin,null,authentication.getAuthorities()));
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation("更新用户密码")
    @PutMapping("/admin/password")
    public RespBean updatePassword(@RequestBody Map<String,Object> map){
        String oldPassword = (String) map.get("oldPassword");
        String password = (String) map.get("password");
        Integer adminId = (Integer) map.get("adminId");
        return adminService.updateAdminPassword(oldPassword,password,adminId);
    }
}
