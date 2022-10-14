package com.seu.learn.commonclass;

import org.testng.annotations.Test;
import java.util.Date;

public class DateTimeTest {

    // System 类中的currentTimeMillis()
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        // 返回当前时间与1970 年1 月1 日0 时0 分0 秒之间以毫秒为单位的时间差。
        // 称为时间戳
        System.out.println(time);
    }

    @Test
    public void test2() {
        // 构造器一：Date()：创建一个对应当前时间的Date 对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        // Sat May 09 20:09:11 CST 2020
        System.out.println(date1.getTime()); // 1589026216998
        // 构造器二：创建指定毫秒数的Date 对象
        Date date2 = new Date(1589026216998L);
        System.out.println(date2.toString());
        // 创建java.sql.Date 对象
        java.sql.Date date3 = new java.sql.Date(35235325345L);
        System.out.println(date3); // 1971-02-13
        // 如何将java.util.Date 对象转换为java.sql.Date 对象
        // 情况一：
        // Date date4 = new java.sql.Date(2343243242323L);
        // java.sql.Date date5 = ( java.sql.Date) date4;
        // 情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }
}
