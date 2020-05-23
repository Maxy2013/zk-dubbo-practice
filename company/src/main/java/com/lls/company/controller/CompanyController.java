package com.lls.company.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lls.entity.Computer;
import com.lls.service.CompanyService;
import com.lls.service.ComputerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzheng
 * @since 8:57 2020/3/16
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Reference
    private CompanyService companyService;

    @Reference
    private ComputerService computerService;

    @RequestMapping("/saveCompany")
    public String saveCompany(String name){
        return companyService.saveCompany(name);
    }

    @RequestMapping("/saveComputer")
    public Computer saveComputer(String name){
        return computerService.saveComputer(name);
    }
}
