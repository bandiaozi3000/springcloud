package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


public interface DeptDao {

    public int addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
