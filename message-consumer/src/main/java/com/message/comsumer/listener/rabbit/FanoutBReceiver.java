package com.message.comsumer.listener.rabbit;

import com.lls.common.CommonConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuzheng
 * @since 11:24 2020/5/17
 */
@Component
@RabbitListener(queues = CommonConstants.QUEUE_FANOUT_B)
public class FanoutBReceiver {

    @RabbitHandler
    public void process(Map message){
        System.out.println("Fanout.B 接收到的消息" + message.toString());
    }
}
