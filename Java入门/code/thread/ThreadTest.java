package com.seu.learn.thread;

// 例子: 遍历100 以内的所有的偶数
// 1. 创建一个继承于Thread 类的子类
class MyThread extends Thread {
    // 2. 重写Thread 类的run()
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        // 3. 创建Thread 类的子对象
        MyThread t1 = new MyThread();
        // 4.通过此对象调用start(): ①启动当前线程 ②调用当前线程的run()
        t1.start();
        // 问题1: 我们不能通过直接调用run() 的方式启动线程。
        // t1.run();
        // 问题二: 再启动一个线程，遍历100 以内的偶数。不可以还让已经start() 的线程去执行。会报IllegalThreadStateException
        // t1.start();
        // 我们需要重现创建一个线程的对象，去start().
        MyThread t2 = new MyThread();
        t2.start();
        // 如下操作仍在main 线程中执行的
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().
                        getName() + ":" + i + "***main()***");
            }
        }
    }
}
