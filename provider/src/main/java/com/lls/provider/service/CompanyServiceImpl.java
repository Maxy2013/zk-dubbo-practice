package com.lls.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lls.service.CompanyService;

/**
 * @author liuzheng
 * @since 23:55 2020/3/15
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Override
    public String getCompanyName(String name) {
        return "恭喜获得公司名称【" + name + "】";
    }

    @Override
    public String saveCompany(String name) {
        return "保存成功:" + name;
    }
}
