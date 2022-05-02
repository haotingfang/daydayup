package com.example.threadlocaldemo;

import com.example.threadlocaldemo.service.UserService1;
import com.example.threadlocaldemo.util.DateUtil;
import com.example.threadlocaldemo.util.NewDateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class ThreadlocaldemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 15; i++) {
            executorService.execute(() -> {
                try {
                    DateUtil.parse("2021-08-03 15:00:20");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 15; i++) {
            executorService.execute(() -> {
                try {
                    NewDateUtil.parse("2021-08-03 15:00:20");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Autowired
    private UserService1 userService1;

    @Test
    public void test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            executorService.execute(() -> {
                    userService1.process(finalI,"张"+finalI);
            });
        }
    }

}
