package com.atguigu.springcloud.serviceImpl;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

   @Autowired
   private DeptDao deptDao;

    @Override
    @CacheRemove(commandKey ="findById")
    public int addDept(@CacheKey("id") Dept dept) {
        return deptDao.addDept(dept);
    }

    /**
     * 正解：请求缓存不是只写入一次结果就不再变化的，而是每次请求到达Controller的时候，我们都需要为
     * HystrixRequestContext进行初始化，之前的缓存也就是不存在了，我们是在同一个请求中保证结果相同，
     * 同一次请求中的第一次访问后对结果进行缓存，缓存的生命周期只有一次请求！
     * @param id
     * @return
     */
    @Override
    @CacheResult(cacheKeyMethod = "cacheId")
    @HystrixCommand(fallbackMethod = "getByIdFallback",ignoreExceptions = SQLSyntaxErrorException.class)
    public Dept findById(Long id) throws Exception {
        System.out.println("*******执行查询*******");
        if(id==1){
            throw new Exception();
        }
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    public Dept getByIdFallback(Long id){
        Dept dept = new Dept();
        dept.setDeptNo(id);
        dept.setdName("该id"+id+"没有对应的信息");
        dept.setDbSource("no this database in Mysql");
        return dept;
    }

    public String cacheId(Long id){
        return String.valueOf(id);
    }
}
