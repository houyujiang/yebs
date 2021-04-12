package com.mornd.server.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mornd.server.pojo.*;
import com.mornd.server.service.*;
import com.mornd.server.utils.IdUtil;
import com.mornd.server.vo.EmployeeVo;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/14 - 15:04
 * 员工控制层
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private NationService nationService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private JoblevelService joblevelService;
    @Resource
    private PoliticsStatusService politicsStatusService;
    @Resource
    private PositionService positionService;

    @ApiOperation("获取所有员工（分页）")
    @GetMapping("/")
    public DataGridView<Employee> getAllEmployees(EmployeeVo employeeVo){
        return employeeService.getAllEmployees(employeeVo);
    }

    @ApiOperation("获取工号")
    @GetMapping("/getWorkID")
    public String getWorkID(){
        //截取15位作为工号
        return IdUtil.getUUID().substring(0,15).toUpperCase();
    }

    @ApiOperation("添加员工")
    @PostMapping("/")
    public RespBean addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @ApiOperation("修改员工")
    @PutMapping("/")
    public RespBean editEmployee(@RequestBody Employee employee){
        return employeeService.editEmployee(employee);
    }

    @ApiOperation("删除员工")
    @DeleteMapping("/{id}")
    public RespBean deleteEmployee(@PathVariable("id") Integer id){
        if(employeeService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation("员工数据导出")
    @GetMapping(value = "/export",produces = "application/octet-stream")
    public void employeeExport(HttpServletResponse response){
        //查询所有员工详细详细
        List<Employee> employees = employeeService.getEmployeeById(null);
        ExportParams exportParams = new ExportParams("员工表","员工表", ExcelType.HSSF);
        Workbook sheets = ExcelExportUtil.exportExcel(exportParams, Employee.class, employees);
        ServletOutputStream outputStream = null;
        try {
            //以流形式导出
            response.setHeader("content-type","application/octet-stream");
            //防止中文乱码
            response.setHeader("content-disposition","attachment;filename=" +
                    URLEncoder.encode("员工表.xls","UTF-8"));
            outputStream = response.getOutputStream();
            //写出数据
            sheets.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @ApiOperation("员工数据导入")
    @PostMapping("/import")
    public RespBean employeeImport(MultipartFile file){
        ImportParams importParams = new ImportParams();
        //去掉标题行防止报错
        importParams.setTitleRows(1);
        //获取所有民族
        List<Nation> nations = nationService.list();
        //部门
        List<Department> departments = departmentService.list();
        //职称
        List<Joblevel> joblevels = joblevelService.list();
        //职位
        List<Position> positions = positionService.list();
        //政治面貌
        List<PoliticsStatus> politicsStatuses = politicsStatusService.list();
        try {
            List<Employee> employees = ExcelImportUtil.importExcel(file.getInputStream(), Employee.class, importParams);
            employees.forEach(employee -> {
                //设置员工对象的民族id
                employee.setNationId(nations.get(
                        nations.indexOf(new Nation(employee.getNation().getName()))
                ).getId());
                //设置员工对象的部门id
                employee.setDepartmentId(departments.get(
                        departments.indexOf(new Department(employee.getDepartment().getName()))
                ).getId());
                //设置员工对象的职称id
                employee.setJobLevelId(joblevels.get(
                        joblevels.indexOf(new Joblevel(employee.getJoblevel().getName()))
                ).getId());
                //设置员工对象的政治面貌id
                employee.setPoliticId(politicsStatuses.get(
                        politicsStatuses.indexOf(new PoliticsStatus(employee.getPoliticsStatus().getName()))
                ).getId());
                //设置员工对象的职位id
                employee.setPosId(positions.get(
                        positions.indexOf(new Position(employee.getPosition().getName()))
                ).getId());
            });
            if(employeeService.saveBatch(employees)){
                return RespBean.success("导入成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBean.error("导入失败！");
    }
}
