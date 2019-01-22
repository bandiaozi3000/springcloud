package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Dept;

import java.util.List;

//@Mapper
public interface DeptDao {

    public int addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
