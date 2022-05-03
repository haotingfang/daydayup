package com.example.annotationdemo.config;

import com.example.annotationdemo.entity.Color;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
