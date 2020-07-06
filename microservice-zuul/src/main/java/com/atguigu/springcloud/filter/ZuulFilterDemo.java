package com.atguigu.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过继承ZuulFilter来自定义过滤器
 * @author zgd
 * @time 2018年8月1日14:18:06
 */
@Component
public class ZuulFilterDemo extends ZuulFilter {




    /**
     * 过滤类型,可以选"pre,routing,post"
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }


    /**
     * 过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否进行过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        String flag = request.getHeader("flag");
        Boolean f = true;
        if (flag != null){
            f = Boolean.valueOf(flag);
        }
        System.out.println("是否过滤 = " + f);
        return f;
    }

    /**
     * 拦截的具体业务代码
     * @return
     */
    @Override
    public Object run() {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        HttpServletResponse response = rc.getResponse();
        System.out.println("调用了过滤器");
        String money = request.getParameter("money");
        if (money == null){
            try {
                doSomething();
                rc.setSendZuulResponse(false);
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("没有钱不给过");
            } catch (IOException e) {
                e.printStackTrace();
            }catch (Exception e){
                throw new ZuulRuntimeException(e);
            }
        }

        return null;
    }

    public void doSomething()  {
        throw new RuntimeException("error.......");
    }
}
