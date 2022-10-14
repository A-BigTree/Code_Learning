package com.seu.learn.thread;

class HelloThread1 extends Thread {
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            // try {
            // sleep(10);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            if (j % 2 == 0) {
                System.out.println(getName() + ":" + getPriority()
                        + ":" + j);
            }
        }
    }

    public HelloThread1(String name) {
        super(name);
    }
}

public class ThreadModeTest1 {
    public static void main(String[] args) {
        HelloThread1 h2 = new HelloThread1("Thread : 1");
        h2.start();
        // 设置分线程的优先级
        h2.setPriority(Thread.MAX_PRIORITY);
        // 给主线程命名
        Thread.currentThread().setName(" 主线程");
        Thread.currentThread().setPriority((Thread.MIN_PRIORITY));
        for (int j = 0; j < 100; j++) {
            if (j % 2 == 0) {
                System.out.println(
                        Thread.currentThread().getName() + ":" +
                                Thread.currentThread().getPriority() + ":" + j);
            }
            // if( j == 20){
            // try {
            // h2.join();
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            // }
        }
        System.out.println(h2.isAlive());
    }
}