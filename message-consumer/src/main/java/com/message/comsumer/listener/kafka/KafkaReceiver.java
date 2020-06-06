package com.message.comsumer.listener.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lls.common.CommonConstants;
import com.lls.entity.db.MsgPerson;
import com.message.comsumer.mapper.MsgPersonMapper;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author liuzheng
 * @since 13:49 2020/6/6
 */
@Component
public class KafkaReceiver {

    @Autowired
    private MsgPersonMapper msgPersonMapper;


    @KafkaListener(topics = CommonConstants.KAFKA_TOPIC)
    public void kafkaListen(ConsumerRecord<?, ?> record){

        Optional<Object> kafkaMessage = Optional.ofNullable(record.value());
        CommonConstants.THREAD_POOL_EXECUTOR.submit(() -> {
            if(kafkaMessage.isPresent()){
                String message = (String) kafkaMessage.get();
                System.out.println("record = " + record);
                System.out.println("message = " + message);

                JSONObject jsonObject = JSON.parseObject(message);
                Long id = jsonObject.getLong("id");

                MsgPerson person = new MsgPerson();
                person.setStatus('1');
                person.setSalary(12121.3);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                person.setModifyTime(new Date());
                msgPersonMapper.update(person, Wrappers.<MsgPerson>query().eq("id", id));
            }
        });
    }
}
