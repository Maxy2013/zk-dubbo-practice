package com.lls.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lls.common.CommonConstants;
import com.lls.provider.config.rabbitmq.DirectRabbitConfig;
import com.lls.provider.config.rabbitmq.TopicRabbitConfig;
import com.lls.service.RabbitMqMsgService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author liuzheng
 * @since 8:54 2020/5/16
 */
@Service
public class RabbitMqMsgServiceImpl implements RabbitMqMsgService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.topic-exchange}")
    public String TOPIC_EXCHANGE;

    @Override
    public String sendDirectMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        int i = 3000;
        while (i > 0) {
            rabbitTemplate.convertAndSend(DirectRabbitConfig.EXCHANGE_NAME, DirectRabbitConfig.ROUTE_NAME, map);
            i--;
        }
        return "OK";
    }

    @Override
    public String sendTopicMessageMan() {
//        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M-A-N";
//        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
//        map.put("messageId",messageId);
        map.put("messageData", messageData);
//        map.put("createTime",createTime);
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, TopicRabbitConfig.MAN, map);
//        int i = 3000;
//        while (i > 0){
//            rabbitTemplate.convertAndSend(DirectRabbitConfig.EXCHANGE_NAME, DirectRabbitConfig.ROUTE_NAME, map);
//            i--;
//        }
        return "OK";
    }

    @Override
    public String sendTopicMessageAll() {
//        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: W-O-M-A-N，ALL in ALL";
//        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
//        map.put("messageId",messageId);
        map.put("messageData", messageData);
//        map.put("createTime",createTime);
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, TopicRabbitConfig.WOMAN, map);
        return "OK";
    }

    /**
     * 扇形交换机
     */
    @Override
    public String senFanoutMessage() {
        String messageData = "message: Fanout Message, 扇形交换机";
        Map<String, Object> map = new HashMap<>();
        map.put("messageData", messageData);
        rabbitTemplate.convertAndSend(CommonConstants.EXCHANGE_FANOUT, null, map);
        return "OK";
    }

    /**
     * 无交换机，有队列
     */
    @Override
    public String sendNoneExchangeMessage() {
        String messageData = "message: W-O-M-A-N，ALL in ALL";
        Map<String, Object> map = new HashMap<>();
        map.put("messageData", messageData);
        rabbitTemplate.convertAndSend("none-existing-exchange", DirectRabbitConfig.EXCHANGE_NAME, map);
        return "OK";
    }

    /**
     * 有交换机，有队列，但无绑定关系
     */
    @Override
    public String sendExchangeRoutingNotBindingMessage() {
        //lonelyDirectExchange 与 TestDirectExchange 无绑定关系


        String messageData = "message: W-O-M-A-N，ALL in ALL";
        Map<String, Object> map = new HashMap<>();
        map.put("messageData", messageData);
        rabbitTemplate.convertAndSend("lonelyDirectExchange", DirectRabbitConfig.EXCHANGE_NAME, map);
        return "OK";
    }
}
