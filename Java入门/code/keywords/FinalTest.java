package com.seu.learn.keywords;

public class FinalTest {
    final int WIDTH = 0;
    final int LEFT;
    final int RIGHT;

    // final int DOWN;
    {
        LEFT = 1;
    }

    public FinalTest() {
        RIGHT = 2;
    }

    public FinalTest(int n) {
        RIGHT = n;
    }

    // public void setDown(int down){
    // this.DOWN = down;
    // }
    public void dowidth() {
        // width = 20; //width cannot be resolved to a variable
    }

    public void show() {
        final int NUM = 10; // 常量
        // num += 20;
    }

    public void show(final int num) {
        System.out.println(num);
    }

    public static void main(String[] args) {
        int num = 10;
        num = num + 5;
        FinalTest test = new FinalTest();
        // test.setDown(5);
        test.show(10);
    }
}

final class FianlA {
}

//class B extends FinalA{ // 错误，不能被继承。
//
//}
//class C extends String{
//
//}
class AA {
    public final void show() {
    }
}
