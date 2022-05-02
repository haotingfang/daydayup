package com.example.filterdemo.filter;

import com.example.filterdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@Component
public class MyFilter implements Filter {

    @Autowired
    private TestService testService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----MyFilter init----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----MyFilter doFilter----");
        testService.hello();
        String source = servletRequest.getParameter("source");
        //  过滤掉source为app的请求
        if (!"app".equals(source)) {
            System.out.println("---- source!= app ----");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("----MyFilter destroy----");
    }
}
