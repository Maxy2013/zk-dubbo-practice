package com.lls.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lls.service.KafkaMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liuzheng
 * @since 11:08 2020/5/17
 */
@RestController
@RequestMapping("/kafkaMessage")
public class KafkaMessageController {

    @Autowired
    private ThreadPoolExecutor executor;

    @Reference
    private KafkaMsgService kafkaMsgService;

    @GetMapping("/send")
    public String send(){
        executor.submit(() -> {
            for(int i = 0; i < 2; i++){
                kafkaMsgService.send();
            }
        });
        return "OK";
    }


    @GetMapping("/insertMessage")
    public String insertMessage(){
        executor.submit(() -> {
            int i = 10;
            while (i > 0){
                kafkaMsgService.insertMessage(i);
                i--;
            }
        });
        return "OK";
    }

}
