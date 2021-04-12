package com.mornd.server.controller;

import com.mornd.server.pojo.Admin;
import com.mornd.server.service.AdminService;
import com.mornd.server.vo.AdminVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/28 - 15:04
 * 在线聊天
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Resource
    private AdminService adminService;

    @ApiOperation("获取所有操作员")
    @GetMapping("/admin")
    public List<Admin> getAdmins(String keywords){
        AdminVo adminVo = new AdminVo();
        adminVo.setPage(1);
        adminVo.setSize(1000);
        return adminService.getAllAdmins(adminVo).getRecords();
    }

}
