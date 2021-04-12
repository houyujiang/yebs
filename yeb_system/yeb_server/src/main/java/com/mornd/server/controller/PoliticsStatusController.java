package com.mornd.server.controller;

import com.mornd.server.pojo.PoliticsStatus;
import com.mornd.server.service.PoliticsStatusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/20 - 22:18
 */
@RestController
@RequestMapping("/employee/basic")
public class PoliticsStatusController {
    @Resource
    private PoliticsStatusService politicsStatusService;

    @ApiOperation("获取所有政治面貌信息")
    @GetMapping("/getAllPoliticsStatus")
    public List<PoliticsStatus> getAllPoliticsStatus(){
        return politicsStatusService.list();
    }
}
