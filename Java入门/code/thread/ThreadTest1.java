package com.seu.learn.thread;

// 1. 创建一个实现了Runnable 接口的类
class MThread implements Runnable {
    // 2. 实现类去实现Runnable 中的抽象方法:run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().
                        getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        // 3. 创建实现类的对象
        MThread m1 = new MThread();
        // 4. 将此对象作为参数传递到Thread 类的构造器中，创建Thread 类的对象
        Thread t1 = new Thread(m1);
        // 5. 通过Thread 类的对象调用start(): ①启动线程 ②调用当前线程的run() --> 调用了Runnable 类型的target 的run()
        t1.start();
        // 再启动一个线程，遍历100 以内的偶数
        Thread t2 = new Thread(m1);
        t2.setName(" 线程2");
        t2.start();
    }
}
