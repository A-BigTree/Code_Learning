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
}
