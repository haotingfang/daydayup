package com.example.demo.config;

import com.example.demo.entity.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Person.class)
public class MyConfig {

    @Bean
    public Person person1(){
        return new Person(1,"张三");
    }

}
