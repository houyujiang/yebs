package com.mornd.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mornd.server.pojo.PoliticsStatus;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mornd
 * @date 2021/2/20 - 22:16
 * 政治面貌持久层
 */
@Mapper
public interface PoliticsStatusMapper extends BaseMapper<PoliticsStatus> {
}
