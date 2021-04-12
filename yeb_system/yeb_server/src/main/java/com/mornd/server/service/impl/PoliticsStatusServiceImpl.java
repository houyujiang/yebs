package com.mornd.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mornd.server.mapper.PoliticsStatusMapper;
import com.mornd.server.pojo.PoliticsStatus;
import com.mornd.server.service.PoliticsStatusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mornd
 * @date 2021/2/20 - 22:17
 * 政治面貌业务层
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PoliticsStatusServiceImpl extends ServiceImpl<PoliticsStatusMapper,PoliticsStatus> implements PoliticsStatusService {
}
