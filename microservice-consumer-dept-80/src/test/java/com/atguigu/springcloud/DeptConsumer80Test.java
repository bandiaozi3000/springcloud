package com.atguigu.springcloud;

import com.atguigu.springcloud.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DeptConsumer80Test {

    private final  String url_prefix="http://127.0.0.1:8001";
    @Autowired
    private RestTemplate restTemplate;
     @Test
    public void test(){
         Dept dept = new Dept();
         dept.setDname("aaaa");
         System.out.println(dept.getDname());
         System.out.println(restTemplate.postForObject(url_prefix+"/dept",dept,boolean.class));
     }
}