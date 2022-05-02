package com.example.filterdemo.config;

import com.example.filterdemo.filter.MyFilter;
import com.example.filterdemo.interceptor.MyInterceptor1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    private MyFilter myFilter;

    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Autowired
    private MyInterceptor1 myInterceptor1;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //每个拦截器的调用会依据它的声明顺序依次执行
        registry.addInterceptor(myInterceptor1).addPathPatterns("/**");
    }
}
