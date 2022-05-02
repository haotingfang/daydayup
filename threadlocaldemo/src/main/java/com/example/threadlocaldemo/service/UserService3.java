package com.example.threadlocaldemo.service;

import com.example.threadlocaldemo.entity.User;
import com.example.threadlocaldemo.util.UserUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService3 {

    public void process(){
        User user = UserUtil.threadLocal.get();
        System.out.println(Thread.currentThread().getName()+"--------UserService3 get user-------"+ user);
    }

}
