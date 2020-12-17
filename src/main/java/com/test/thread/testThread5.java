package com.test.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 20:54
 * @description：测试SingleThreadScheduledExecutor
 */
public class testThread5 {
    public static void SingleThreadScheduledExecutor() {
        // 创建线程池
        ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
        // 添加定时执行任务(2s 后执行)
        for (int i=0;i<4;i++) {

    final  int index=i;
            System.out.println(index+"添加任务,时间:" + new Date());
            threadPool.schedule(() -> {
                System.out.println(index+"任务被执行,时间:" + new Date());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
            }, 2, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) {
        SingleThreadScheduledExecutor();
    }
}
