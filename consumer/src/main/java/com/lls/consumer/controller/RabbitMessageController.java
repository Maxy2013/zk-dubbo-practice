package com.lls.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lls.service.RabbitMqMsgService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzheng
 * @since 11:08 2020/5/17
 */
@RestController
@RequestMapping("/rabbitMessage")
public class RabbitMessageController {

    @Reference
    private RabbitMqMsgService rabbitMqMsgService;

    @RequestMapping("/sendDirectMessage")
    public String sendDirectMessage(){
        return rabbitMqMsgService.sendDirectMessage();
    }

    @RequestMapping("/sendTopicMessageMan")
    public String sendTopicMessageMan(){
        return rabbitMqMsgService.sendTopicMessageMan();
    }

    @RequestMapping("/sendTopicMessageAll")
    public String sendTopicMessageAll(){
        return rabbitMqMsgService.sendTopicMessageAll();
    }

    @RequestMapping("/sendNoneExchangeMessage")
    public String sendNoneExchangeMessage(){
        return rabbitMqMsgService.sendNoneExchangeMessage();
    }

    @RequestMapping("/sendExchangeRoutingNotBindingMessage")
    public String sendExchangeRoutingNotBindingMessage(){
        return rabbitMqMsgService.sendExchangeRoutingNotBindingMessage();
    }

    @RequestMapping("/senFanoutMessage")
    public String senFanoutMessage(){
        return rabbitMqMsgService.senFanoutMessage();
    }
}
