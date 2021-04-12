package com.mornd.server.config.security;

import com.mornd.server.config.security.component.*;
import com.mornd.server.pojo.Admin;
import com.mornd.server.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author mornd
 * @date 2021/1/31 - 13:34
 * security配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private AdminService adminService;
    //注入当未登录或者token失效时访问接口时，自定义的返回结果
    @Resource
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;
    //注入当访问接口没有权限时，自定义返回结果
    @Resource
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    //根据请求的url分析请求所需的角色
    @Resource
    private CustomFilter customFilter;
    //断用户角色
    @Resource
    private CustomUrlDecisionManager customUrlDecisionManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //需要直接放行的请求
        web.ignoring().antMatchers(
                "/login",
                "/logout",
                "/captcha",
                "/css/**",
                "/js/**",
                "/index.html",
                "favicon.ico",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/ws/**");
    }

    /**
     * security主配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //基于jwt，舍弃csrf
        http.csrf()
            .disable()
            //基于token，舍弃session
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            //所有请求都要认证
            .anyRequest()
            .authenticated()
            //动态权限配置
            //什么样的角色才能访问什么样的url，否则403
            .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                @Override
                public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                    object.setAccessDecisionManager(customUrlDecisionManager);
                    object.setSecurityMetadataSource(customFilter);
                    return object;
                }
            })
            .and()
            //禁用缓存
            .headers()
            .cacheControl();

        //添加jwt登录过滤器
        http.addFilterBefore(jwtAuthorizationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);
    }

    /**
     * 重写UserDetailsService的登录方法
     * @return
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return username -> {
            Admin admin = adminService.getAdminByUsername(username);
            if(ObjectUtils.isEmpty(admin)){
               return null;
            }
            //如果用户存在则给该用户设置角色列表
            admin.setRoles(adminService.getRoles(admin.getId()));
            return admin;
        };
    }

    /**
     * 注入jwt登录授权过滤器
     * @return
     */
    @Bean
    public JwtAuthorizationTokenFilter jwtAuthorizationTokenFilter(){
        return new JwtAuthorizationTokenFilter();
    }
    /**
     * 注入密码加解密类
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
