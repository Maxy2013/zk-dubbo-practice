package com.lls.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.lls.common.CommonConstants;
import com.lls.entity.db.MsgPerson;
import com.lls.entity.kafka.Message;
import com.lls.provider.mapper.MsgPersonMapper;
import com.lls.service.KafkaMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;

/**
 * @author liuzheng
 * @since 13:42 2020/6/6
 */
@Service
public class KafkaMsgServiceImpl implements KafkaMsgService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private MsgPersonMapper msgPersonMapper;


    @Override
    public void send() {
        long i = System.currentTimeMillis();

        Date date = new Date();
        MsgPerson person = new MsgPerson(i, "张三" + i, 12, "长江路", date, date);
        Message message = new Message(i, person, date);
        int insert = msgPersonMapper.insert(person);
        System.out.println("msgPersonMapper insert [" + insert + "] record(s)");
        kafkaTemplate.send(CommonConstants.KAFKA_TOPIC, JSON.toJSONString(message));
    }

    @Override
    public void insertMessage(int i) {
        Date date = new Date();
        MsgPerson person = new MsgPerson(i, "张三" + i, 12, "长江路");
        int insert = msgPersonMapper.insert(person);
        System.out.println("msgPersonMapper insert [" + insert + "] record(s)");
    }
}
