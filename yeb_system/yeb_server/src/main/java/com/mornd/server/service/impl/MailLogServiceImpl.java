package com.mornd.server.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mornd.server.mapper.MailLogMapper;
import com.mornd.server.pojo.MailLog;
import com.mornd.server.service.MailLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mornd
 * @date 2021/3/3 - 11:57
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper,MailLog> implements MailLogService {

}
