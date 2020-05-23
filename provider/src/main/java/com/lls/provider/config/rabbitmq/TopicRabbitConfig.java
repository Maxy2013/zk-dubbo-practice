package com.lls.provider.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzheng
 * @since 10:52 2020/5/17
 */
@Configuration
public class TopicRabbitConfig {
    public static final String MAN = "topic.man";
    public static final String WOMAN = "topic.woman";

    @Value("${rabbitmq.exchange.topic-exchange}")
    public String TOPIC_EXCHANGE;

    @Bean
    public Queue firstQueue(){
        return new Queue(MAN);
    }

    @Bean
    public Queue secondQueue(){
        return new Queue(WOMAN);
    }

    /**
     * 配置topic交换机
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * 绑定
     * 这样只要是消息携带的路由键是topic.man,才会分发到该队列
     */
    @Bean
    public Binding bindingExchangeMessageFirst(){
        return BindingBuilder.bind(firstQueue()).to(topicExchange()).with(MAN);
    }

    /**
     * 绑定
     * 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
     */
    @Bean
    public Binding bindingExchangeMessageSecond(){
        return BindingBuilder.bind(secondQueue()).to(topicExchange()).with("topic.#");
    }

}
