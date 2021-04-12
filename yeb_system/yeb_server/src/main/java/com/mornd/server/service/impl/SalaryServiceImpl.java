package com.mornd.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mornd.server.mapper.EmployeeMapper;
import com.mornd.server.mapper.SalaryMapper;
import com.mornd.server.pojo.DataGridView;
import com.mornd.server.pojo.Employee;
import com.mornd.server.pojo.Salary;
import com.mornd.server.service.EmployeeService;
import com.mornd.server.service.SalaryService;
import com.mornd.server.vo.SalaryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/24 - 12:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper,Salary> implements SalaryService {
    @Resource
    private EmployeeMapper employeeMapper;
    /**
     * 获取工资账套
     * @param salaryVo
     * @return
     */
    @Override
    public DataGridView<Salary> getSalary(SalaryVo salaryVo) {
        IPage<Salary> page = new Page<>(salaryVo.getPage(),salaryVo.getSize());
        QueryWrapper<Salary> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtils.isEmpty(salaryVo.getName()),"name",salaryVo.getName());
        super.page(page,wrapper);
        return new DataGridView<>(page.getTotal(),page.getRecords());
    }

    /**
     * 删除工资账套
     * @param id
     * @return
     */
    @Override
    public boolean removeById(Serializable id) {
        //删除员工信息
        employeeMapper.removeBySaiaryId(id);
        return super.removeById(id);
    }
}
