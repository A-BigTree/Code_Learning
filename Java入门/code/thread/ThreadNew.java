package com.seu.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1. 创建一个实现Callable 的实现类
class NumThread implements Callable {
    // 2. 实现call 方法，将此线程需要执行的操作声明在call() 中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        // 3. 创建Callable 接口实现类的对象
        NumThread numThread = new NumThread();
        // 4. 将此Callable 接口实现类的对象作为传递到FutureTask 构造器中，创建FutureTask 的对象
        FutureTask futureTask = new FutureTask(numThread);
        // 5. 将FutureTask 的对象作为参数传递到Thread 类的构造器中，创建Thread 对象，并调用start()
        new Thread(futureTask).start();
        try {
            // 6. 获取Callable 中call 方法的返回值
            // get() 返回值即为FutureTask 构造器参数Callable 实现类重写的call() 的返回值。
            Object sum = futureTask.get();
            System.out.println(" 总和为:" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
