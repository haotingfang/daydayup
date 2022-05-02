package com.example.threadlocaldemo.util;

import com.example.threadlocaldemo.entity.User;

public class UserUtil {

    public static ThreadLocal<User> threadLocal = new ThreadLocal<>();
}
