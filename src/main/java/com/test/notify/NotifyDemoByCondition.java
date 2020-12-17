package com.test.notify;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 22:30
 * @description：处理假死问题执行结果
 */
public class NotifyDemoByCondition {
    public static void main(String[] args) {
        FactoryByCondition factory = new FactoryByCondition();

        // 生产者
        Thread producer = new Thread(() -> {
            try {
                factory.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者");
        producer.start();

        // 生产者 2
        Thread producer2 = new Thread(() -> {
            try {
                factory.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者2");
        producer2.start();

        // 消费者
        Thread consumer = new Thread(() -> {
            try {
                factory.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者");
        consumer.start();
    }
}

