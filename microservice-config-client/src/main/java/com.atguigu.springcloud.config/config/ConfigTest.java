package com.atguigu.springcloud.config.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 只有加@RefreshScope这个注解的类调用/actuator/refresh才会刷新配置
 * */
@RestController
@RefreshScope
public class ConfigTest {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping(value = "/config/test")
    public void testConfig(){
        System.out.println(configInfo);
    }
}
