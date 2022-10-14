package com.seu.learn.commonclass;

import org.testng.annotations.Test;

public class StringMethodTest {
    @Test
    public void Test1() {
        String s1 = "helloworld";
        System.out.println(s1.length());
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
        // System.out.println(s1.charAt(10));
        // s1 = "";
        System.out.println(s1.isEmpty());
        String s2 = s1.toLowerCase();
        System.out.println(s1);// s1 不可变的，仍然为原来的字符串
        System.out.println(s2);// 改成小写以后的字符串
        String s3 = " he llo world ";
        String s4 = s3.trim();
        System.out.println("-----" + s3 + "-----");
        System.out.println("-----" + s4 + "-----");
    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2)); // false
        System.out.println(s1.equalsIgnoreCase(s2));// true
        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);// abcdef
        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6)); // -2
        // 涉及到字符串的排序
        String s7 = "周围好吵啊";
        String s8 = s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);
        String s9 = s7.substring(0, 2);
        System.out.println(s9);
    }

    @Test
    public void test3() {
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("rld");
        System.out.println(b1);
        boolean b2 = str1.startsWith("He");
        System.out.println(b2);
        boolean b3 = str1.startsWith("ll", 2);
        System.out.println(b3);
        String str2 = "wor";
        System.out.println(str1.contains(str2));
        System.out.println(str1.indexOf("lo"));
        System.out.println(str1.indexOf("lo", 5));
        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or", 6));
        // 什么情况下，indexOf(str) 和lastIndexOf(str) 返回值相同？
        // 情况一：存在唯一的一个str。情况二：不存在str
    }

    @Test
    public void test4() {
        String str1 = " 西藏布达拉宫欢迎您";
        String str2 = str1.replace('西', '东');
        System.out.println(str1);
        System.out.println(str2);
        String str3 = str1.replace("西藏", "南京");
        System.out.println(str3);
        System.out.println("*************************");
        String str = "12hello34world5java7891mysql456";
        // 把字符串中的数字替换成','，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);
        System.out.println("*************************");
        str = "12345";
        // 判断str 字符串中是否全部有数字组成，即有1-n 个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        // 判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);
        System.out.println("*************************");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
}
