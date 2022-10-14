package com.seu.learn.commonclass;

import org.testng.annotations.Test;

public class StringTest {
    @Test
    public void Test1() {
        String s1 = "abc"; // 字面量的定义方式
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1 == s2); // 比较s1 和s2 的地址值
        System.out.println(s1); // hello
        System.out.println(s2); // abc
        System.out.println("*********************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3); // abcdef
        System.out.println("**********************");
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4); // abc
        System.out.println(s5); // mbc
    }

    @Test
    public void test2() {
        // 通过字面量定义的方式：此时的s1 和s2 的数据javaEE 声明在方法区中的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";
        // 通过new + 构造器的方式：此时的s3 和s4 保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false
        System.out.println(s3 == s4); // false
        System.out.println("***********************");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);
        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true
        System.out.println("***********************");
        Person p3 = new Person("Tom");
        Person p4 = new Person("Tom");
        System.out.println(p3.name == p4.name);
    }

    @Test
    public void test4() {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3); // false
        final String s4 = "javaEE"; // s4:常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5); // true
    }

    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s5 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false
        String s8 = s5.intern(); // 返回值得到的s8 使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8); // true
    }

    String str = "good";
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str); // good
        System.out.println(ex.ch); // best
    }
}

class Person {
    public String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = new String(name);
    }

    public Person() {
    }
}
