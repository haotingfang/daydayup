package com.example.annotationdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class AnnotationDemoApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        String[] name = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }

        System.out.println("-----------------------------");
        Object bean1 = applicationContext.getBean("myFactoryBean");
        System.out.println(bean1);
        Object bean2 = applicationContext.getBean("&myFactoryBean");
        System.out.println(bean2);
    }


}
