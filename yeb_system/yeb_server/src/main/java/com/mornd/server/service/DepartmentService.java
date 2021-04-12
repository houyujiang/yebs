package com.mornd.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mornd.server.pojo.Department;
import com.mornd.server.pojo.RespBean;

import java.util.List;

/**
 * @author mornd
 * @date 2021/2/8 - 14:33
 */
public interface DepartmentService extends IService<Department> {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 判断该部门下是否有子部门
     * @param id
     * @return
     */
    Integer findContainChildren(Integer id);

    /**
     * 删除部门
     * @param id
     * @return
     */
    RespBean removeById(Integer id);

    /**
     * 修改该部门的父部门
     * @param id
     * @param parentId
     * @return
     */
    boolean editParentId(Integer id, Integer parentId);
}
