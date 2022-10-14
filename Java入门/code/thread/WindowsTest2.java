package com.seu.learn.thread;

class Windows extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 正确的
            // synchronized (obj) {
            synchronized (Windows.class) {
            // Class class = Windows.class
            // 错误的，因为此时this 表示的是t1,t2,t3 三个对象
            // synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ": 卖票， 票号为: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowsTest2 {
    public static void main(String[] args) {
        Windows t1 = new Windows();
        Windows t2 = new Windows();
        Windows t3 = new Windows();
        t1.setName(" 窗口1");
        t2.setName(" 窗口2");
        t3.setName(" 窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
