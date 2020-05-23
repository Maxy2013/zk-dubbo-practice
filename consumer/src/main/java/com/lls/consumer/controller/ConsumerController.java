package com.lls.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lls.service.CompanyService;
import com.lls.service.ConsumerService;
import com.lls.service.RabbitMqMsgService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzheng
 * @since 22:21 2020/3/15
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Reference
    private ConsumerService consumerService;

    @Reference
    private CompanyService companyService;

    @RequestMapping("/consumerName")
    public String consumerName(String name){
        return consumerService.getName(name);
    }

    @RequestMapping("/getCompanyName")
    public String getCompanyName(String name) {
        return companyService.getCompanyName(name);
    }


}
