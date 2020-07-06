package com.atguigu.springcloud.Service;

import com.atguigu.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory = DeptFeignServiceFallbackFactory.class)
public interface DeptFeignService {
    @GetMapping("/dept")
    List<Dept> getAll();

    @GetMapping("/dept/{id}")
    Dept getById(@PathVariable("id") Long id);

    @PostMapping("/dept")
    int addDept(@RequestBody Dept dept);

}
