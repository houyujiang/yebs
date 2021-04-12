package com.mornd.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mornd.server.pojo.MailLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mornd
 * @date 2021/3/3 - 11:37
 */
@Mapper
public interface MailLogMapper extends BaseMapper<MailLog> {
}
