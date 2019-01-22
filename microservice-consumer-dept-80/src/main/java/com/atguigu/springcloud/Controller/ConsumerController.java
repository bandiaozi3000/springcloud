package com.atguigu.springcloud.Controller;

import com.atguigu.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    private final  String url_prefix="http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(url_prefix+"/dept",dept,boolean.class);
    }

    @RequestMapping("/consumer/dept/{id}")
    public Dept getById(@PathVariable("id") Long id) {
       return restTemplate.getForObject(url_prefix + "/dept/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept")
    public List<Dept> getAll(){
        return restTemplate.getForObject(url_prefix+"/dept",List.class);
    }

    @RequestMapping("/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(url_prefix+"/dept/discovery",Object.class);
    }

}
