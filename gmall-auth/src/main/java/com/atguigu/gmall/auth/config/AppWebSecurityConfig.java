package com.atguigu.gmall.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author shkstart
 * @create 2021-04-09 14:08
 */
@Configuration
@EnableWebSecurity
public class AppWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//super.configure(http); //取消默认配置 
        http.authorizeRequests()

                .antMatchers("/layui/**","/index.jsp").permitAll() //设置匹配的资源放行
                .anyRequest().authenticated(); //剩余任何资源必须认证
    }

    @Autowired
    UserDetailsService userDetailsService;//用户详情查询服务组件的接口
//    @Autowired
//    PasswordEncoder passwordEncoder;//密码加密自定义

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//根据用户名查询出用户的详细信息
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); //测试：分析源码（验证密码不一致）
    }
}
