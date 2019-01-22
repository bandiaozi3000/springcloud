package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.atguigu.springcloud.dao")
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002.class,args);
    }
}
