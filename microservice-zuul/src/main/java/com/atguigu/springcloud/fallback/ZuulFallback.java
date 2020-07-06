//package com.atguigu.springcloud.fallback;
//
//
//import com.netflix.zuul.ZuulFilterResult;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.stereotype.Component;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * @author: linjie
// * @description:错误拦截回显，熔断
// * @create: 2018/10/11 20:01
// */
//@Component
//public class ZuulFallback {
//
//    @Override
//    public String getRoute() {
//        //设置熔断的服务名
//        //如果是所有服务则设置为*
//        return "*";
//    }
//
//    @Override
//    public ClientHttpResponse fallbackResponse() {
//        return new ClientHttpResponse() {
//            @Override
//            public HttpStatus getStatusCode() throws IOException {
//                return HttpStatus.OK;
//            }
//
//            @Override
//            public int getRawStatusCode() throws IOException {
//                return 200;
//            }
//
//            @Override
//            public String getStatusText() throws IOException {
//                return "{\n" +
//                        "\t\"code\": 0,\n" +
//                        "\t\"message\": \"service error = _ =\"\n" +
//                        "}";
//            }
//
//            @Override
//            public void close() {
//
//            }
//
//            @Override
//            public InputStream getBody() throws IOException {
//                return new ByteArrayInputStream(getStatusText().getBytes());
//            }
//
//            @Override
//            public HttpHeaders getHeaders() {
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.APPLICATION_JSON);
//                return headers;
//            }
//        };
//    }
//}
