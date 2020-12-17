package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 19:27
 * @description：FixedThreadPool进阶写法
 */
public class testThreadG {
    public static void fixedThreadPool() {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
       /*
       * 执行任务
       * 为了个之前得进行统一，所以这里通过for循环，同样是提交4个执行*/
        for(int i=1;i<=4;i++) {
            threadPool.execute(() -> {
                System.out.println("任务被执行,线程:" + Thread.currentThread().getName());
            });
        }
    }

    public static void main(String[] args) {
        fixedThreadPool();
    }
}
