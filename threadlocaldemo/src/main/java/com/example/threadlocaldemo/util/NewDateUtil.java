package com.example.threadlocaldemo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewDateUtil {

    public static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        @Override
        public DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-HH-dd HH:mm:ss");
        }
    };


    public static Date parse(String dateStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) threadLocal.get();
        Date date = threadLocal.get().parse(dateStr);
        System.out.println(Thread.currentThread().getName()+" , "+threadLocal+" , "+simpleDateFormat+" , "+date);
        return date;
    }

}
