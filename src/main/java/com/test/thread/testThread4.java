package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 20:17
 * @description：测试singleThreadExecutor
 */
public class testThread4 {

    public static void singleThreadExecutor() {
        // 创建线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;

            threadPool.execute(() -> {
                new Thread();
                System.out.println(Thread.currentThread().getName()+"开始时间[" + new java.util.Date().getTime());
                System.out.println(index + ":任务被执行");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName()+"结束时间[" + new java.util.Date().getTime());
            });
        }
    }

    public static void main(String[] args) {
       singleThreadExecutor();

    }
}
