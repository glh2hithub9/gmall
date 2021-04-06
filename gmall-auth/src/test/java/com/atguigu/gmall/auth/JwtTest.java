package com.atguigu.gmall.auth;

import com.atguigu.core.utils.JwtUtils;
import com.atguigu.core.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JwtTest {
	private static final String pubKeyPath = "D:\\develop\\git_code\\temp\\rsa.pub";

    private static final String priKeyPath = "D:\\develop\\git_code\\temp\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "ssd23243sFED%&^*&2132");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "11");
        map.put("username", "张琦架构师");
        // 生成token
        String token = JwtUtils.generateToken(map, privateKey, 1);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6IjExIiwidXNlcm5hbWUiOiLlvKDnkKbmnrbmnoTluIgiLCJleHAiOjE2MTcxODQ2NDR9.OWZwOTt8YsOMaTCstqX4d0EXmo2aDuMb1aa1ocmkuIbU30Mn5N6qIfx0N3GVgra1rZLbp8WjTGWj3Yd8kCZOcwMgqn_Mhb6qZMl5xsUdrl_MyVHNthSBVSOHDtbA3vRkxRDMnsfoi_HS5l0EZjT7nwoNc20FEXmUbb03_7wS1Tvf4qbR-5rlhdWqm-sHYrX6RKxKtTusRimzYx_E1TITZQqLRGtNvJcrA51kFcaukXUTHjaCZy866-nCMaw_XPvXAci6RL9kx-lTmBoM-xdAXRugDGjtG7tF58gWdJgU1i2-3PtA5LDdYD2ZY1Sw4Tj_oqnbbxMvxVoS2FzAVmLIcw";

        // 解析token
        Map<String, Object> map = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + map.get("id"));
        System.out.println("userName: " + map.get("username"));
    }
}