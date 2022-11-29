/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.reflection
 * =====================================================
 * Title: Person.java
 * Created: [2022/11/17 22:08] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/11/17, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.reflection;

/*
public class Person {
    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public void show() {
        System.out.println(" 你好，我是" + name);
    }

    private String showNation(String nation) {
        System.out.println(" 喷子实在太多了！！！ " + nation);
        return nation;
    }
}*/

@MyAnnotation(value = "java")
public class Person extends Creature<String> implements
        Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;
    public Person() {
    }
    @MyAnnotation(value = "C++")
    Person(String name) {
        this.name = name;
    }
    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation) {
        System.out.println(" 我来自 " + nation + " 星系 ");
        return nation;
    }
    @Override
    public void info() {
        System.out.println(" 火星喷子 ");
    }
    public String display(String play) {
        return play;
    }
    @Override
    public int compareTo(String o) {
        return 0;
    }
}
