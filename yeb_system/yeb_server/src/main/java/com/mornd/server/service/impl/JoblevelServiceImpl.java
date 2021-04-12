package com.mornd.server.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mornd.server.mapper.JoblevelMapper;
import com.mornd.server.pojo.Joblevel;
import com.mornd.server.service.JoblevelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mornd
 * @date 2021/2/3 - 20:30
 * 职称管理业务层
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JoblevelServiceImpl extends ServiceImpl<JoblevelMapper,Joblevel> implements JoblevelService {
}
