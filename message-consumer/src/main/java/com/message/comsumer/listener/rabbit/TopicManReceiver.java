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
@RabbitListener(queues = "topic.man")
public class TopicManReceiver {

    @RabbitHandler
    public void process(Map message){
        System.out.println("Topic【Man】Receiver 接收到的消息" + message.toString());
    }
}
