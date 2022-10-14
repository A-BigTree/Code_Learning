package com.seu.learn.keywords;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flayable.MAX_SPEED);
        System.out.println(Flayable.MIN_SPEED);
    }
}

interface Flayable {
    // 全局变量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1; // 省略了 public static final

    // 抽象方法
    public abstract void fly();

    void stop(); // 省略了 public abstract
    //Interfaces cannot have constructors
    // public Flayable(){
    //
    // }
}

interface Aa {
    void method1();
}

interface BB {
    void method2();
}

interface CC extends Aa, BB {
}

interface Attackable {
    void attack();
}

class Plane implements Flayable {
    @Override
    public void fly() {
        System.out.println(" 飞机通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println(" 驾驶员减速停止");
    }
}

abstract class Kite implements Flayable {
    @Override
    public void fly() {
    }
}

class Bullet extends Object implements Flayable, Attackable, CC {
    @Override
    public void attack() {
        // TODO Auto-generated method stub
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    @Override
    public void method1() {
        // TODO Auto-generated method stub
    }

    @Override
    public void method2() {
        // TODO Auto-generated method stub
    }
}
