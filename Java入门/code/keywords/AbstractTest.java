package com.seu.learn.keywords;

public class AbstractTest {
    public static void main(String[] args) {
        // 一旦 Person 类抽象了，就不可实例化
        // Person p1 = new Person(); // p1.eat();
    }
}

abstract class Creature {
    public abstract void breath();
}

abstract class Person extends Creature {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 不是抽象方法
    // public void eat(){
    // System.out.println(" 人吃饭");
    // }
    // 抽象方法
    public abstract void eat();

    public void walk() {
        System.out.println(" 人走路");
    }
}

class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    public void eat() {
        System.out.println(" 学生应该多吃有营养的。");
    }

    @Override
    public void breath() {
        System.out.println(" 学生应该呼吸新鲜的无雾霾空气");
    }
}