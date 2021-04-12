package com.mornd.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mornd.server.pojo.Nation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mornd
 * @date 2021/2/20 - 22:11
 * 民族持久层
 */
@Mapper
public interface NationMapper extends BaseMapper<Nation> {
}
