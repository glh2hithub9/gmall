package com.atguigu.gmall.auth.service;

import com.atguigu.gmall.auth.utils.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2021-04-09 21:56
 */
@Service
public class AppPasswordEncoder implements PasswordEncoder {

    /**
     * 密码加密的算法
     */
    @Override
    public String encode(CharSequence rawPassword) {
        String digestPwd = MD5Util.digestPwd(rawPassword.toString(),32);
        return digestPwd;
    }

    /**
     * 比较登录密码和数据库存储密码是否一致
     * rawPassword:页面的明文密码
     * encodedPassword：数据库的密文密码
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//使用自己的工具类
        String digestPwd = MD5Util.digestPwd(rawPassword.toString(),32);
        return digestPwd.equals(encodedPassword);
    }
}