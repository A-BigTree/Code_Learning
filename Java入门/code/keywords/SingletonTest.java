package com.seu.learn.keywords;

public class SingletonTest {
    public static void main(String[] args) {
        // Bank bank1 = new Bank();
        // Bank bank2 = new Bank();
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
    }
}

// 单例的饿汉式
class Bank{
    //1. 私有化类的构造器
    private Bank(){
    }
    //2. 内部创见类的对象
    //4. 要求此对象也必须声明为静态的
    private static Bank instance = new Bank();
    //3. 提供公共的静态的方法，返回类的对象。
    public static Bank getInstance(){
        return instance;
    }
}
