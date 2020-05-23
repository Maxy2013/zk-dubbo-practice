package com.lls.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lls.service.ConsumerService;

/**
 * @author liuzheng
 * @since 22:24 2020/3/15
 */
@Service(
        version = "${dubbo.provider.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class ConsumerServiceImpl implements ConsumerService {


    @Override
    public String getName(String name) {
        return "得到名称《" + name + "》";
    }
}
