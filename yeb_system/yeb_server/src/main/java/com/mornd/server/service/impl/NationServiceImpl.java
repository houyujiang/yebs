package com.mornd.server.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mornd.server.mapper.NationMapper;
import com.mornd.server.pojo.Nation;
import com.mornd.server.service.NationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mornd
 * @date 2021/2/20 - 22:12
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NationServiceImpl extends ServiceImpl<NationMapper,Nation> implements NationService {

}
