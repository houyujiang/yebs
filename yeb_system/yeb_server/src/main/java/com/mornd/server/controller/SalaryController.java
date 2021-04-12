package com.mornd.server.controller;

import com.mornd.server.pojo.DataGridView;
import com.mornd.server.pojo.RespBean;
import com.mornd.server.pojo.Salary;
import com.mornd.server.service.SalaryService;
import com.mornd.server.vo.SalaryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/24 - 12:45
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Resource
    private SalaryService salaryService;

    @ApiOperation("获取工资账套(分页)")
    @GetMapping("/")
    public DataGridView<Salary> getSalary(SalaryVo salaryVo){
        return salaryService.getSalary(salaryVo);
    }

    @ApiOperation("添加工资账套")
    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary){
        salary.setCreateDate(new Date());
        if(salaryService.save(salary)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation("修改工资账套")
    @PutMapping("/")
    public RespBean editSalary(@RequestBody Salary salary){
        if(salaryService.updateById(salary)){
            return RespBean.success("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @ApiOperation("删除工资账套")
    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable Integer id){
        if(salaryService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }





}
