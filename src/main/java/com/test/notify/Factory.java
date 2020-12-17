package com.test.notify;

/**
 * @author ：biws
 * @date ：Created in 2020/12/17 22:11
 * @description：工厂类,消费者和生产者通过调用工厂类实现生产/消费
 */
public class Factory {

        private int[] items = new int[1]; // 数据存储容器(为了演示方便,设置容量最多存储 1 个元素)
        private int size = 0;             // 实际存储大小

        /**
         * 生产方法
         */
        public synchronized void put() throws InterruptedException {
            // 循环生产数据
            do {
                while (size == items.length) { // 注意不能是 if 判断
                    // 存储的容量已经满了,阻塞等待消费者消费之后唤醒
                    System.out.println(Thread.currentThread().getName() + " 进入阻塞");
                    this.wait();
                    System.out.println(Thread.currentThread().getName() + " 被唤醒");
                }
                System.out.println(Thread.currentThread().getName() + " 开始工作");
                items[0] = 1; // 为了方便演示,设置固定值
                size++;
                System.out.println(Thread.currentThread().getName() + " 完成工作");
                // 当生产队列有数据之后通知唤醒消费者
                this.notify();

            } while (true);
        }

        /**
         * 消费方法
         */
        public synchronized void take() throws InterruptedException {
            // 循环消费数据
            do {
                while (size == 0) {
                    // 生产者没有数据,阻塞等待
                    System.out.println(Thread.currentThread().getName() + " 进入阻塞(消费者)");
                    this.wait();
                    System.out.println(Thread.currentThread().getName() + " 被唤醒(消费者)");
                }
                System.out.println("消费者工作~");
                size--;
                // 唤醒生产者可以添加生产了
                this.notify();
            } while (true);
        }
    }

