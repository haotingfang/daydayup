package com.example.interceptordemo.config;

import com.example.interceptordemo.interceptor.MyInterceptor1;
import com.example.interceptordemo.interceptor.MyInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor1 myInterceptor1;

    @Autowired
    private MyInterceptor2 myInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //每个拦截器的调用会依据它的声明顺序依次执行
        registry.addInterceptor(myInterceptor1).addPathPatterns("/**");
        registry.addInterceptor(myInterceptor2).addPathPatterns("/**");
    }
}
