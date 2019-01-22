package com.atguigu.springcloud;

import com.aiguigu.springcloud.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.atguigu.springcloud")
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MyIRule.class)
public class DeptConsumer80_Feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign.class,args);
    }
}
