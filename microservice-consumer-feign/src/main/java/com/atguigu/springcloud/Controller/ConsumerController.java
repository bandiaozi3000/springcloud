package com.atguigu.springcloud.Controller;

import com.atguigu.springcloud.Service.DeptFeignService;
import com.atguigu.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private DeptFeignService deptFeignService;


    @RequestMapping("/consumer/dept/add")
    public int addDept(Dept dept){
        return deptFeignService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/{id}")
    public Dept getById(@PathVariable("id") Long id) {
       return deptFeignService.getById(id);
    }

    @RequestMapping("/consumer/dept")
    public List<Dept> getAll(){
        return deptFeignService.getAll();
    }

//    @RequestMapping("/consumer/dept/discovery")
//    public Object discovery(){
//        return restTemplate.getForObject(url_prefix+"/dept/discovery",Object.class);
//    }

}
