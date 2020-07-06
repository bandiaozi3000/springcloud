//package com.atguigu.springcloud.component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//
//
//@SpringBootConfiguration
//public class MySpringMVCConfig extends WebMvcConfigurationSupport {
//	@Autowired
//	private HystrixInterceptor hystrixInterceptor;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(hystrixInterceptor).addPathPatterns("/**");
//	}
//}
