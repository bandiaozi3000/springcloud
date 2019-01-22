package com.atguigu.springcloud.Service;

import com.atguigu.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptFeignServiceFallbackFactory implements FallbackFactory<DeptFeignService> {
    @Override
    public DeptFeignService create(Throwable throwable) {
        return new DeptFeignService() {
            @Override
            public List<Dept> getAll() {
                return null;
            }

            @Override
            public Dept getById(Long id) {
                Dept dept = new Dept();
                dept.setDeptNo(id);
                dept.setDname("该id" + id + "没有对应的服务信息,Consumer客户端提供的降级信息，此刻服务Provider已停止服务");
                dept.setDb_source("no this database in Mysql");
                return dept;
            }

            @Override
            public int addDept(Dept dept) {
                return 0;
            }
        };
    }
}
