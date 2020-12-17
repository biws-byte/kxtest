package com.test.notify;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 22:12
 * @description：测试线程假死类
 */
public class NotifyDemo {

        public static void main(String[] args) {
            // 创建工厂类
            Factory factory = new Factory();

            // 生产者
            Thread producer = new Thread(() -> {
                try {
                    factory.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "生产者");
            producer.start();

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

