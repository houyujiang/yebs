package com.mornd.server.controller;

import com.mornd.server.pojo.Nation;
import com.mornd.server.service.NationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/20 - 22:13
 * 民族控制层
 */
@RestController
@RequestMapping("/employee/basic")
public class NationController {
    @Resource
    private NationService nationService;

    @ApiOperation("获取所有民族信息")
    @GetMapping("/getAllNation")
    public List<Nation> getAllNation(){
        return nationService.list();
    }
}
