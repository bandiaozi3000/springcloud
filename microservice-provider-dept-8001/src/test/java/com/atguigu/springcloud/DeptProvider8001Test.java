package com.atguigu.springcloud;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DeptProvider8001Test {


    @Autowired
    DeptService deptService;

    @Test
    public void print(){
//        System.out.println(deptService.findById(1).getDname());
    }

    @Test
    public void print2(){
        System.out.println(deptService.findAll());
    }
}