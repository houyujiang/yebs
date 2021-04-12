package com.mornd.server.vo;

import com.mornd.server.pojo.Employee;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author mornd
 * @date 2021/2/14 - 15:06
 */
@Data
public class EmployeeVo extends Employee {
    private Integer page;
    private Integer size;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date[] beginDateScope;
}
