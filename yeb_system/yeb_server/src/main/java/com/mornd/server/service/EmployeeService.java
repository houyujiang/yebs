package com.mornd.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mornd.server.pojo.DataGridView;
import com.mornd.server.pojo.Employee;
import com.mornd.server.pojo.RespBean;
import com.mornd.server.vo.EmployeeVo;

import java.util.List;

/**
 * @author mornd
 * @date 2021/2/8 - 17:13
 */
public interface EmployeeService extends IService<Employee> {
    /**
     * 根据条件查询员工（分页）
     * @param employeeVo
     * @return
     */
    DataGridView<Employee> getAllEmployees(EmployeeVo employeeVo);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmployee(Employee employee);

    /**
     * 修改员工
     * @param entity
     * @return
     */
    RespBean editEmployee(Employee entity);


    /**
     * 根据id查询详细员工详细
     * @param id
     * @return
     */
    List<Employee> getEmployeeById(Integer id);

    /**
     * 获取员工账套
     * @param name
     * @param workId
     * @param page
     * @param size
     * @return
     */
    DataGridView<Employee> getEmployeeWithSalary(String name, String workId, Integer page, Integer size);
}
