package com.seu.learn.commonclass;

import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

    @Test
    public void testSimpleDateFormat() throws ParseException {
        // 实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();
        // 格式化：日期---》字符串
        Date date = new Date();
        System.out.println(date); // Sun May 10 16:34:30 CST 2020
        String format = sdf.format(date);
        System.out.println(format); // 20-5-10 下午4:34
        // 解析：格式化的逆过程，字符串---》日期
        String str = "19-12-18 上午11:43";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
        // Wed Dec 18 11:43:00 CST 2019
        // ************* 按照指定的方式格式化和解析：调用带参的构造器*****************
        // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy. MMMMM.dd GGG hh:mm aaa");
        // 格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        // 02020. 五月.10 公元 04:32 下午
        // 解析: 要求字符串必须是符合SimpleDateFormat 识别的格式(通过构造器参数体现),
        // 否则，抛异常
        Date date2 = sdf1.parse("02020. 五月.10 公元 04:32 下午");
        System.out.println(date2);
        // Sun May 10 16:32:00 CST 2020
    }

    // 练习1：字符串"2020-09-08" 转换为java.sql.Date
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy- MM-dd");
        Date date = sdf1.parse(birth);
        // System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    //Calendar 日历类的使用
    @Test
    public void testCalendar() {
        // 1. 实例化
        // 方式一：创建其子类（GregorianCalendar）的对象
        // 方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        // System.out.println(calendar.getClass());
        //class java.util.GregorianCalendar
        // 2. 常用方法
        // get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 10
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        // 131, 今天是这一年的131 天
        // set()
        // calendar 可变性
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 22
        // add()
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 22-3 --》19
        // getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date); // Tue May 19 17:12:06 CST 2020
        // setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 10
    }
}
