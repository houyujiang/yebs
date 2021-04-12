package com.mornd.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mornd.server.pojo.DataGridView;
import com.mornd.server.pojo.Position;
import com.mornd.server.pojo.RespBean;
import com.mornd.server.service.PositionService;
import com.mornd.server.vo.PositionVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/3 - 19:35
 * 职位管理控制器
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Resource
    private PositionService positionService;

    @ApiOperation(value = "获取所有职位(分页)")
    @GetMapping("/")
    public DataGridView<Position> getAllPositions(PositionVo positionVo){
        //分页对象
        IPage<Position> page = new Page<>(positionVo.getPage(),positionVo.getSize());
        //查询条件
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtils.isEmpty(positionVo.getName()),"name",positionVo.getName());
        wrapper.orderByDesc("create_date");
        positionService.page(page,wrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @ApiOperation("获取所有职位")
    @GetMapping("/getAllPositions")
    public List<Position> getAllSimplePositions(){
        return positionService.list();
    }

    @ApiOperation(value = "添加职位")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        position.setCreateDate(LocalDateTime.now());
        if(positionService.save(position)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "修改职位")
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if(positionService.updateById(position)){
            return RespBean.success("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @ApiOperation(value = "删除职位")
    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable("id") Integer id){
        if(positionService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "批量删除职位")
    @DeleteMapping("/")
    public RespBean batchDeletePosition(Integer[] ids){
        if(positionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除成功！");
        }
        return RespBean.error("批量删除失败！");
    }
}
