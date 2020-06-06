package com.message.comsumer.listener.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuzheng
 * @since 11:24 2020/5/17
 */
@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalReceiver {

    @RabbitHandler
    public void process(Map message){
        System.out.println("Topic【Total】Receiver 接收到的消息" + message.toString());
    }
}
