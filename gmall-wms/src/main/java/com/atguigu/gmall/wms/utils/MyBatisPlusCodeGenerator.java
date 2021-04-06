package com.atguigu.gmall.wms.utils;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author shkstart
 * @create 2021-03-26 10:49
 */
public class MyBatisPlusCodeGenerator {
    public final static String projectName="gmall-wms";

    public static void main(String[] args) {
        String packageName="com.atguigu.gmall.wms";

    }

    private static void generateByTables(String packageName,String...tableNames){
        GlobalConfig config=new GlobalConfig();
        String dbUrl="jdbc:mysql://127.0.0.0:3306/guli-wms?useUnicode=true&characterEncoding=utf-8&&zeroDateTimeBehavior=convertToNull";
        DataSourceAutoConfiguration dataSourceConfig=new DataSourceAutoConfiguration();
    }
}
