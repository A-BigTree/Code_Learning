package com.seu.learn.wrapper;

import org.testng.annotations.Test;

public class JUnit {
    int num = 10;
    // 第一个单元测试方法
    @Test
    public void testEquals(){
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
//ClassCastException 的异常
// Object obj = new String("GG");
// Date date = (Date)obj;
        System.out.println(num);
        show();
    }
    public void show(){
        num = 20;
        System.out.println("show()...");
    }
    // 第二个单元测试方法
    @Test
    public void testToString(){
        String s2 = "MM";
        System.out.println(s2.toString());
    }
}
