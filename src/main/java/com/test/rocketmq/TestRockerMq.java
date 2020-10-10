package com.test.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.*;

public class TestRockerMq {

        public static void main(String[] args) throws Exception {
//创建一个消息消费者，并设置一个消息消费者组
             final DefaultMQPushConsumer consumer = new DefaultMQPushConsumer( "niwei_consumer_group");
//指定Nameserver地址
            consumer.setNamesrvAddr("localhost:9876");
//设置 consumer第一次启动时是从队列头部还是队列尾部开始消费的
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//订闷指定Topic 下的所有消息
            consumer.subscribe("topic_example_java","*");
//注册消息监听器
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    {
                        //默认list里只有一条消息，可以通过设置参数来批量接收消息
                        if (list != null) {
                            for (MessageExt ext : list) {
                                try {
                                    System.out.println(new Date() + new String(ext.getBody(), "UTF-8"));
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                }
            });
//消费者对象在使用之前必须要调用start方法初始
                        consumer.start();
                    System.out.println("消息消费者已启动");
        }
}