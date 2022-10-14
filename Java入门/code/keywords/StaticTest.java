package com.seu.learn.keywords;

public class StaticTest {
    public static void main(String[] args) {
        Chinese.nation = " 中国";
        Chinese c1 = new Chinese();
        // 编译不通过
        // Chinese.name = " 张继科";
        c1.eat();
        Chinese.show();
        // 编译不通过
        // chinese.eat(); // Chinese.info();
    }
}
// 中国人
class Chinese{
    String name;
    int age;
    static String nation;
    public void eat(){
        System.out.println(" 中国人吃中餐");
        // 调用非静态结构
        this.info();
        System.out.println("name : " + name);
        // 调用静态结构
        walk();
        System.out.println("nation : " + Chinese.nation);
    }
    public static void show(){
        System.out.println(" 我是一个中国人！ ");
        // eat();
        // name = "Tom";
        // 可以调用静态的结构
        System.out.println(Chinese.nation);
        walk();
    }
    public void info(){
        System.out.println("name : " + name + ",age : " + age);
    }
    public static void walk(){
    }
}