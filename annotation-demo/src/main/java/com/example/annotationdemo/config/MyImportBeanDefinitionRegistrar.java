package com.example.annotationdemo.config;

import com.example.annotationdemo.entity.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
      Boolean redB = registry.containsBeanDefinition("com.example.annotationdemo.entity.Red");
      Boolean blueB = registry.containsBeanDefinition("com.example.annotationdemo.entity.Blue");
      if( redB && blueB){
          BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
          registry.registerBeanDefinition("rainBow",beanDefinition);
      }

    }
}
