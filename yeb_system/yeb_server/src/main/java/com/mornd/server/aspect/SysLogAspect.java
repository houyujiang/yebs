/*
package com.mornd.server.aspect;

import com.alibaba.fastjson.JSON;
import com.mornd.server.annotation.LogStar;
import com.mornd.server.exception.GlobalException;
import com.mornd.server.pojo.Admin;
import com.mornd.server.pojo.SysLog;
import com.mornd.server.service.SysLogService;
import com.mornd.server.utils.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

*/
/**
 * @author mornd
 * @date 2021/1/13 - 15:47
 * 自定义日志切面
 *//*

@Slf4j
@Aspect
@Order(5)
@Component
public class SysLogAspect {
    */
/**
     * 全局异常处理
     *//*

    @Resource
    private GlobalException exceptionHandler;
    */
/**
     *  日志业务层
     *//*

    @Resource
    private SysLogService sysLogService;

    */
/**
     * 操作时长记录
     *//*

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    */
/**
     * 日志实体类
     *//*

    private SysLog sysLog;

    */
/**
     * 切入点
     *//*

    @Pointcut("@annotation(com.mornd.server.annotation.LogStar)")
    public void pc(){
    }

    */
/**
     * 前置通知
     * @param joinPoint
     *//*

    @Before("pc()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("前置通知执行...");
        startTime.set(System.currentTimeMillis());
        //获取request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //获取标题
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogStar logStar = method.getAnnotation(LogStar.class);
        String title = logStar.value();

        //类名
        String declaringTypeName = signature.getDeclaringTypeName();

        //方法名
        String methodName = signature.getName();

        //方法参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Object o = args[i];
            if(o instanceof ServletRequest || o instanceof ServletResponse || o instanceof MultipartFile){
                args[i] = o.toString();

            }
        }
        String param = JSON.toJSONString(args);

        //IP地址
        String ip = NetUtil.getIpAddress(request);
        if("0.0.0.0".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
            ip = "127.0.0.1";
        }

        //请求url
        String url = request.getRequestURL().toString();

        //获取操作系统和浏览器信息
        String osAndBrowser = NetUtil.getOsAndBrowserInfo(request);

        //sessionId
        String sessionId = request.getSession().getId();

        //请求方式
        String requestMethod = request.getMethod();

        //是否是Ajax请求
        boolean isAjax = NetUtil.isAjaxRequest(request);

        //给日志实体赋值
        sysLog = new SysLog();
        sysLog.setVisitTime(new Date());
        sysLog.setTitle(title);
        sysLog.setClassName(declaringTypeName);
        sysLog.setMethod(methodName);
        sysLog.setParam(param.length() > 500 ? "参数数据过长,不予显示" : param);
        sysLog.setIp(ip);
        sysLog.setUrl(url);
        sysLog.setOsAndBrowser(osAndBrowser);
        sysLog.setSessionId(sessionId);
        sysLog.setReqMethod(requestMethod);
        sysLog.setIsAjax(isAjax ? "是" : "否");
        //获取当前操作用户
        Admin principal = (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!ObjectUtils.isEmpty(principal)){
            sysLog.setUserName(principal.getUsername());
            sysLog.setUserId(principal.getId());
        }
    }

    */
/**
     * 后置通知
     * @param ret
     *//*

    @AfterReturning(pointcut = "pc()",returning = "ret")
    public void doAfterReturning(Object ret){
        log.info("后置通知执行...");
        //获取当前操作用户
        Admin principal = (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!ObjectUtils.isEmpty(principal) && ObjectUtils.isEmpty(sysLog.getUserName()) && ObjectUtils.isEmpty(sysLog.getUserId())){
            sysLog.setUserName(principal.getUsername());
            sysLog.setUserId(principal.getId());
        }
        //返回结果
        String result = JSON.toJSONString(ret);
        Long executionTime = System.currentTimeMillis() - startTime.get();
        sysLog.setExecutionTime(executionTime);
        sysLog.setResult(result.length() > 500 ? "结果过长,不予显示" : result);
        //执行保存
        sysLogService.save(sysLog);
    }

    */
/**
     * 环绕通知
     *//*

    @Around("pc()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object obj = pjp.proceed();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            sysLog.setException(e.getMessage());
            throw e;
        }
    }
}
*/
