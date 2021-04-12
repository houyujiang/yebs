package com.mornd.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mornd.server.pojo.Salary;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mornd
 * @date 2021/2/24 - 12:47
 */
@Mapper
public interface SalaryMapper extends BaseMapper<Salary> {
}
