package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {
    public int addDept(Dept dept);

    public Dept findById(Long id) throws Exception;

    public List<Dept> findAll();
}
