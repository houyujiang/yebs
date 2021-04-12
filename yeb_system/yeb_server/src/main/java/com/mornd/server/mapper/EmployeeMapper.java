package com.mornd.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mornd.server.pojo.Employee;
import com.mornd.server.vo.EmployeeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;


/**
 * @author mornd
 * @date 2021/2/8 - 17:13
 * 员工实体
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 根据条件查询员工（分页）
     * @param page
     * @param employeeVo
     * @return
     */
    IPage<Employee> getAllEmployees(IPage<Employee> page, @Param("employeeVo") EmployeeVo employeeVo);

    /**
     * 根据id查询详细员工详细
     * @param id
     * @return
     */
    List<Employee> getEmployeeById(Integer id);

    /**
     * 获取员工账套
     * @param page
     * @param name
     * @param workId
     * @return
     */
    IPage<Employee> getEmployeeWithSalary(IPage page, @Param("name") String name, @Param("workId") String workId);

    /**
     * 根据salaryId删除员工信息
     * @param id
     * @return
     */
    Integer removeBySaiaryId(Serializable id);
}
