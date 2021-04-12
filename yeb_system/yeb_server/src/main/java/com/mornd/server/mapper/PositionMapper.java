package com.mornd.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mornd.server.pojo.Position;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mornd
 * @date 2021/2/3 - 19:37
 * 职位持久层
 */
@Mapper
public interface PositionMapper extends BaseMapper<Position> {
}
