package com.seu.learn.thread;

class Windows1 implements Runnable {
    private int ticket = 100;

    // Object obj = new Object();
    // Dog dog = new Dog();
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 此时的this: 唯一的windows1 的对象 // 方式二:synchronized (dog) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().
                            getName() + ": 卖票，票号为: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowsTest1 {
    public static void main(String[] args) {
        Windows1 w = new Windows1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName(" 窗口1");
        t2.setName(" 窗口2");
        t3.setName(" 窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Dog {
}
