package com.mornd.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mornd.server.mapper.EmployeeMapper;
import com.mornd.server.mapper.MailLogMapper;
import com.mornd.server.pojo.*;
import com.mornd.server.service.EmployeeService;
import com.mornd.server.utils.IdUtil;
import com.mornd.server.vo.EmployeeVo;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author mornd
 * @date 2021/2/8 - 17:13
 * 员工业务层
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private MailLogMapper mailLogMapper;
    /**
     * 根据条件查询员工（分页）
     *
     * @param employeeVo
     * @return
     */
    @Override
    public DataGridView<Employee> getAllEmployees(EmployeeVo employeeVo) {
        //开启分页
        IPage<Employee> page = new Page<>(employeeVo.getPage(),employeeVo.getSize());
        page = baseMapper.getAllEmployees(page,employeeVo);
        return new DataGridView<>(page.getTotal(),page.getRecords());
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Override
    public RespBean addEmployee(Employee employee) {
        if(ObjectUtils.isEmpty(employee)){
            return RespBean.error("提交数据为空！");
        }
        if(ObjectUtils.isEmpty(employee.getSchool())){
            employee.setSchool("无");
        }
        if(ObjectUtils.isEmpty(employee.getSpecialty())){
            employee.setSpecialty("无");
        }
        if(!ObjectUtils.isEmpty(super.getOne(
                new QueryWrapper<Employee>().eq("work_id",employee.getWorkId())))){
            return RespBean.error("该工号已存在！");
        }
        //处理合同期限
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        try {
            //合同截止日期减去合同起始日期
            employee.setContractTerm((double) ((endContract.getTime() - beginContract.getTime()) / (24*60*60*1000)));
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("日期类型处理发生异常!");
        }
        if(super.save(employee)){
            //数据库记录发送的消息
            String uuid = IdUtil.getUUID();
            MailLog mailLog = new MailLog();
            mailLog.setMsgId(uuid);
            mailLog.setEId(employee.getId());
            //设置发送状态为0 消息投递中
            mailLog.setStatus(0);
            mailLog.setRouteKey(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
            mailLog.setCount(0);
            mailLog.setTryTime(LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT));
            mailLog.setCreateTime(LocalDateTime.now());
            mailLog.setUpdateTime(LocalDateTime.now());
            mailLogMapper.insert(mailLog);
            //rabbitmq发送消息
            Employee emp = baseMapper.getEmployeeById(employee.getId()).get(0);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME,MailConstants.MAIL_ROUTING_KEY_NAME,
                    emp,new CorrelationData(uuid));

            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    /**
     * 修改员工
     * @param entity
     * @return
     */
    @Override
    public RespBean editEmployee(Employee entity) {
        if(ObjectUtils.isEmpty(entity)){
            return RespBean.error("提交数据为空！");
        }
        //处理合同期限
        Date beginContract = entity.getBeginContract();
        Date endContract = entity.getEndContract();
        try {
            entity.setContractTerm((double) ((endContract.getTime() - beginContract.getTime()) / (24*60*60*1000)));
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("日期类型处理发生异常!");
        }
        if(super.updateById(entity)){
            return RespBean.success("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    /**
     * 根据id查询详细员工详细
     * @param id
     * @return
     */
    @Override
    public List<Employee> getEmployeeById(Integer id) {
        return baseMapper.getEmployeeById(id);
    }

    /**
     * 获取员工账套
     *
     * @param name
     * @param workId
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public DataGridView<Employee> getEmployeeWithSalary(String name, String workId, Integer currentPage, Integer size) {
        IPage<Employee> page = new Page<>(currentPage,size);
        page = baseMapper.getEmployeeWithSalary(page,name,workId);
        return new DataGridView<>(page.getTotal(),page.getRecords());
    }
}
