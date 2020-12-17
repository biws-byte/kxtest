package com.test.notify;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 22:15
 * @description：线程假死问题
 * 当创建两个生产者得时候会出现什么情况？
 */
public class NotifyDemo2 {
    public static void main(String[] args) {
        // 创建工厂方法（工厂类的代码不变，这里不再复述）
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
