package com.example.annotationdemo.config;

import com.example.annotationdemo.entity.Student;
import com.example.annotationdemo.entity.Teacher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import sun.awt.SunHints;

@Configuration
@Import({Student.class,MyImportSeletor.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig {

    @Bean
    public Student student1(){
        return new Student(1,"学生张三");
    }

    @Bean
    @ConditionalOnBean(name="student")
    public Teacher teacher(){
        return new Teacher(1,"老师里斯");
    }

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }
}
