package com.mornd.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mornd.server.pojo.Admin;
import com.mornd.server.pojo.DataGridView;
import com.mornd.server.pojo.RespBean;
import com.mornd.server.pojo.Role;
import com.mornd.server.service.AdminService;
import com.mornd.server.service.RoleService;
import com.mornd.server.vo.AdminVo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/9 - 23:00
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private RoleService roleService;

    @ApiOperation("获取所有操作员(不包括当前登录的操作员，分页)")
    @GetMapping("/")
    public DataGridView<Admin> getAllAdmins(AdminVo adminVo){
        IPage<Admin> allAdmins = adminService.getAllAdmins(adminVo);
        return new DataGridView<>(allAdmins.getTotal(),allAdmins.getRecords());
    }

    @ApiOperation("修改操作员")
    @PutMapping("/updateAdmin")
    public RespBean updateAdmin(@RequestBody Admin admin){
        if(adminService.updateById(admin)){
            return RespBean.success("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @ApiOperation("修改操作员状态")
    @PutMapping("/")
    public RespBean updateAdminStatus(Integer id,Boolean enabled){
        Admin admin = new Admin();
        admin.setId(id);
        admin.setEnabled(enabled);
        if(adminService.updateById(admin)){
            return RespBean.success("修改成功！");
        }
        return RespBean.error("修改错误！");
    }

    @ApiOperation("删除操作员")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@PathVariable Integer id){
        if(adminService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation("获取所有角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation("更新操作员角色")
    @PutMapping("/role")
    public RespBean updateAdminRole(Integer id, Integer[] rids){
        return adminService.updateAdminRole(id,rids);
    }

}
