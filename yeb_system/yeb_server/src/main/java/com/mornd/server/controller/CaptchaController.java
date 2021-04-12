package com.mornd.server.controller;

import com.mornd.server.constant.RedisConst;
import com.mornd.server.utils.CaptchaUtil;
import com.mornd.server.utils.IdUtil;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mornd
 * @date 2021/1/31 - 16:13
 * 验证码控制器
 */
@Slf4j
@RestController
public class CaptchaController {

    /**
     * 获取图形验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @ApiOperation(value = "获取图形验证码")
    @GetMapping("/captcha")
    public Map captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置相应头
        CaptchaUtil.setHeader(response);
        //使用算数验证码，运算位数为2
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(115,40);
        captcha.setLen(2);
        String captchaResult = captcha.text();
        //存入缓存的key
        String captchaUuid = IdUtil.getUUID();
        Map<String,Object> map = new HashMap<String, Object>(){{
            put("captcha",captcha.toBase64());
            put("captchaUuid", captchaUuid);
        }};
        request.getSession().setAttribute(RedisConst.CAPTCHA_KEY,captchaResult);
        log.info("验证码结果为：" + captchaResult);
        return map;
    }
}
