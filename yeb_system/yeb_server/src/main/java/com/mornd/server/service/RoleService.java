package com.mornd.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mornd.server.pojo.RespBean;
import com.mornd.server.pojo.Role;

import java.util.List;

/**
 * @author mornd
 * @date 2021/2/3 - 20:50
 */
public interface RoleService extends IService<Role> {
    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);

    /**
     * 根据角色id查询菜单id集合
     * @param rid
     * @return
     */
    List<Integer> getMidByRid(Integer rid);
}
