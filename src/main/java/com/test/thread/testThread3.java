package com.test.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 20:43
 * @description：测试ScheduledThreadPool
 */
public class testThread3 {
    public static void scheduledThreadPool() {
        // 创建线程池
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        // 添加定时执行任务(1s 后执行)
        for(int i=0;i<4;i++){
            final int index=i;

        System.out.println(index+"添加任务,时间:" + new Date()+Thread.currentThread().getName());
        threadPool.schedule(() -> {
            System.out.println(index+"任务被执行,时间:" + new Date()+Thread.currentThread().getName());
           /* try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }*/
        }, 1, TimeUnit.SECONDS);
    }
    }
    public static void main(String[] args) {
        scheduledThreadPool();
    }
}
