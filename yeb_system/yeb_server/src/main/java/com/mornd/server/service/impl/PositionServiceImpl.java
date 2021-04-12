package com.mornd.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mornd.server.mapper.PositionMapper;
import com.mornd.server.pojo.Position;
import com.mornd.server.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mornd
 * @date 2021/2/3 - 19:38
 * 职位管理业务层
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PositionServiceImpl extends ServiceImpl<PositionMapper,Position> implements PositionService {
}
