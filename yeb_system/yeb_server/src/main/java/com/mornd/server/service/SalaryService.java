package com.mornd.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mornd.server.pojo.DataGridView;
import com.mornd.server.pojo.Salary;
import com.mornd.server.vo.SalaryVo;

/**
 * @author mornd
 * @date 2021/2/24 - 12:47
 */
public interface SalaryService extends IService<Salary> {
    /**
     * 获取工资账套
     * @param salaryVo
     * @return
     */
    DataGridView<Salary> getSalary(SalaryVo salaryVo);
}
