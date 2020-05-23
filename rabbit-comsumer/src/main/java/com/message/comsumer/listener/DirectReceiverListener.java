package com.message.comsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuzheng
 * @since 10:06 2020/5/16
 */
@Component
@RabbitListener(queues = "testDirectQueue")
public class DirectReceiverListener {

    @RabbitHandler
    public void process(Map message){
        System.out.println("DirectReceiverListener接收到消息：" + message.toString());
    }
}
