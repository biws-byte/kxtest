package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 19:23
 * @description：测试FixedThreadPool
 */
public class testThread1 {
    public static void fixedThreadPool() {
        // 创建 2 个数据级的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        // 创建任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务被执行,线程:" + Thread.currentThread().getName());
            }
        };

     /*   // 线程池执行任务(一次添加 4 个任务)
        // 执行任务的方法有两种:submit 和 execute
        threadPool.submit(runnable);  // 执行方式 1:submit
        threadPool.execute(runnable); // 执行方式 2:execute
        threadPool.execute(runnable);
        threadPool.execute(runnable);*/
     for(int i=0;i<100;i++){
         threadPool.submit(runnable);
        }


    }

    public static void main(String[] args) {
            fixedThreadPool();
    }
}
