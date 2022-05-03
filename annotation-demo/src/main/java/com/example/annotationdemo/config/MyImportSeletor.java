package com.example.annotationdemo.config;

import com.example.annotationdemo.entity.Blue;
import com.example.annotationdemo.entity.Red;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyImportSeletor implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Set<String> set =annotationMetadata.getAnnotationTypes();
        System.out.println("-----------------------------------------------");
        System.out.println(set);
        System.out.println("-----------------------------------------------");
        return new String[]{"com.example.annotationdemo.entity.Red", "com.example.annotationdemo.entity.Blue"};
    }
}
