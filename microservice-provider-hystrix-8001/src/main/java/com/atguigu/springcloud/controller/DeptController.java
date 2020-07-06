package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dept")
    public List<Dept> getAll(){
        return deptService.findAll();
    }

    @GetMapping("/dept/{id}")
    public Dept getById(@PathVariable("id") Long id) throws Exception {
        Dept dept = deptService.findById(id);
        dept = deptService.findById(id);
        dept = deptService.findById(id);
        dept = deptService.findById(id);
        return dept;
    }

    @PostMapping("/dept")
    public int addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

//    @GetMapping("/dept/discovery")
//    public Object discovery(){
//        List<String> list = discoveryClient.getServices();
//        System.out.println("*************"+list);
//        List<ServiceInstance> servList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
//        for(ServiceInstance instance:servList){
//            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
//        }
//        return this.discoveryClient;
//    }



}
