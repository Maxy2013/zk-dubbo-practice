package com.lls.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lls.entity.Computer;
import com.lls.service.ComputerService;

import java.math.BigDecimal;

/**
 * @author liuzheng
 * @since 9:11 2020/3/16
 */
@Service
public class ComputerServiceImpl implements ComputerService {
    @Override
    public Computer saveComputer(String name) {
        Computer computer = new Computer();
        computer.setName(name);
        computer.setPrice(new BigDecimal(12.8));
        computer.setSize(new BigDecimal(9999));
        return computer;
    }
}
