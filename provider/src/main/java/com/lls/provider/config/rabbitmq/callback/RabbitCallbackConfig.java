package com.lls.provider.config.rabbitmq.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzheng
 * @since 14:12 2020/5/17
 */
@Configuration
public class RabbitCallbackConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启mandatory才能出发回调函数，无论推送结果怎么样，都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback 相关数据：" + correlationData);
                System.out.println("ConfirmCallback 确认情况：" + ack);
                System.out.println("ConfirmCallback 原因：" + cause);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback 消息：" + message);
                System.out.println("ReturnCallback 回应码：" + replyCode);
                System.out.println("ReturnCallback 回应信息：" + replyText);
                System.out.println("ReturnCallback 交换机：" + exchange);
                System.out.println("ReturnCallback 路由：" + routingKey);
            }
        });
        return rabbitTemplate;
    }
}
