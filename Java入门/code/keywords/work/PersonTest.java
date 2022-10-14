package com.seu.learn.keywords.work;

// 生物父类
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

    public Student() {
    }

    @Override
    public void eat() {
        System.out.println(" 学生应该多吃有营养的。");
    }

    @Override
    public void breath() {
        System.out.println(" 学生应该呼吸新鲜的无雾霾空气");
    }
}

class Worker extends Person {
    @Override
    public void eat() {
        System.out.println("吃大锅饭");
    }

    @Override
    public void breath() {
    }
}

public class PersonTest {
    public static void main(String[] args) {
        method(new Student()); // 匿名对象
        Worker worker = new Worker();
        method1(worker); // 非匿名的类非匿名的对象
        method1(new Worker()); // 非匿名的类匿名的对象
        System.out.println("*********************");
        // 创建了一个匿名子类的对象:p
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println(" 吃东西");
            }

            @Override
            public void breath() {
                System.out.println(" 呼吸空气");
            }
        };
        method1(p);
        System.out.println("**********************");
        // 创建匿名子类的匿名对象
        method1(new Person() {
            @Override
            public void eat() {
                System.out.println(" 吃零食");
            }

            @Override
            public void breath() {
                System.out.println(" 云南的空气");
            }
        });
    }

    public static void method1(Person p) {
        p.eat();
        p.walk();
    }

    public static void method(Student s) {

    }
}