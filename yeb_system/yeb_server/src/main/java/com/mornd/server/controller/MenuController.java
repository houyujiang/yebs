package com.mornd.server.controller;

import com.mornd.server.pojo.Menu;
import com.mornd.server.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/1 - 16:09
 * 菜单控制器
 */
@RestController
@RequestMapping("/system/config")
public class MenuController {
    @Resource
    private MenuService menuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenuByAdminId(){
        return menuService.getMenuByAdminId();
    }
}
