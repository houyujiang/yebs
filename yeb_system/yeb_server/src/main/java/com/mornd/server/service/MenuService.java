package com.mornd.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mornd.server.pojo.Menu;

import java.util.List;

/**
 * @author mornd
 * @date 2021/2/1 - 16:12
 */
public interface MenuService extends IService<Menu> {
    /**
     * 通过用户id查询菜单列表
     * @return
     */
    List<Menu> getMenuByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
