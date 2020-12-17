package com.test.notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 22:27
 * @description：基于Condition得工厂实现
 */
public class FactoryByCondition {
    private int[] items = new int[1]; // 数据存储容器(为了演示方便,设置容量最多存储 1 个元素)
    private int size = 0;             // 实际存储大小
    // 创建 Condition 对象
    private Lock lock = new ReentrantLock();
    // 生产者的 Condition 对象
    private Condition producerCondition = lock.newCondition();
    // 消费者的 Condition 对象
    private Condition consumerCondition = lock.newCondition();

    /**
     * 生产方法
     */
    public void put() throws InterruptedException {
        // 循环生产数据
        do {
            lock.lock();
            while (size == items.length) { // 注意不能是 if 判断
                // 生产者进入等待
                System.out.println(Thread.currentThread().getName() + " 进入阻塞");
                producerCondition.await();
                System.out.println(Thread.currentThread().getName() + " 被唤醒");
            }
            System.out.println(Thread.currentThread().getName() + " 开始工作");
            items[0] = 1; // 为了方便演示,设置固定值
            size++;
            System.out.println(Thread.currentThread().getName() + " 完成工作");
            // 唤醒消费者
            consumerCondition.signal();
            try {
            } finally {
                lock.unlock();
            }
        } while (true);
    }

    /**
     * 消费方法
     */
    public void take() throws InterruptedException {
        // 循环消费数据
        do {
            lock.lock();
            while (size == 0) {
                // 消费者阻塞等待
                consumerCondition.await();
            }
            System.out.println("消费者工作~");
            size--;
            // 唤醒生产者
            producerCondition.signal();
            try {
            } finally {
                lock.unlock();
            }
        } while (true);
    }
}
