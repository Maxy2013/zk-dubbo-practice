package com.lls.provider.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzheng
 * @since 8:44 2020/5/16
 */
@Configuration
public class DirectRabbitConfig {

    public static final String QUEUE_NAME = "testDirectQueue";
    public static final String EXCHANGE_NAME = "TestDirectExchange";
    public static final String ROUTE_NAME = "TestDirectRouting";

    @Bean
    public Queue testDirectQueue(){
        return new Queue(QUEUE_NAME, true);//默认是true，不传也行
    }

    @Bean
    public DirectExchange testDirectExchange(){
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with(ROUTE_NAME);
    }

    @Bean
    public DirectExchange lonelyDirectExchange(){
        return new DirectExchange("lonelyDirectExchange");
    }
}
