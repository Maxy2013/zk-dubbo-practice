package com.lls.provider.config.rabbitmq;

import com.lls.common.CommonConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzheng
 * @since 16:08 2020/5/20
 */
@Configuration
public class FanoutRabbitConfig {

    /**
     *  创建三个队列 ：fanout.A   fanout.B  fanout.C
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */

    @Bean
    public Queue fanoutQueueA(){
        return new Queue(CommonConstants.QUEUE_FANOUT_A);
    }

    @Bean
    public Queue fanoutQueueB(){
        return new Queue(CommonConstants.QUEUE_FANOUT_B);
    }

    @Bean
    public Queue fanoutQueueC(){
        return new Queue(CommonConstants.QUEUE_FANOUT_C);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(CommonConstants.EXCHANGE_FANOUT);
    }

    /*
     * 将3个队列都绑定到交换机上
     */
    @Bean
    public Binding bindingExchangeA(){
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingExchangeB(){
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingExchangeC(){
        return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
    }

}
