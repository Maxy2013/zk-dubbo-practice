package com.lls.service;

/**
 * @author liuzheng
 * @since 8:53 2020/5/16
 */
public interface RabbitMqMsgService {

    String sendDirectMessage();

    String sendTopicMessageMan();

    String sendTopicMessageAll();

    String senFanoutMessage();

    String sendNoneExchangeMessage();

    String sendExchangeRoutingNotBindingMessage();
}
