package com.aiguigu.springcloud;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyIRule {

    @Bean
    public IRule getIRule(){
        return new MyTestRule();
    }
}
