package com.atguigu.springcloud;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DeptConsumer80Test {

    @Autowired
    private RestTemplate restTemplate;

}