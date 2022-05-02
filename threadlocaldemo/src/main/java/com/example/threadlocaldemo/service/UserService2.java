package com.example.threadlocaldemo.service;

import com.example.threadlocaldemo.entity.User;
import com.example.threadlocaldemo.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService2 {

    @Autowired
    private UserService3 userService3;

    public void process(){
        User user = UserUtil.threadLocal.get();
        System.out.println(Thread.currentThread().getName()+"--------UserService2 get user-------"+ user);
        userService3.process();
    }

}
