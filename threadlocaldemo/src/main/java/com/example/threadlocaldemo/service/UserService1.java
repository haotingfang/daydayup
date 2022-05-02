package com.example.threadlocaldemo.service;

import com.example.threadlocaldemo.entity.User;
import com.example.threadlocaldemo.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService1 {

    @Autowired
    private UserService2 userService2;

    public void process(Integer id , String name){
        User user = new User(id,name);
        UserUtil.threadLocal.set(user);
        System.out.println(Thread.currentThread().getName()+"--------UserService1 set user-------"+ user);
        userService2.process();
    }

}
