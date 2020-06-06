package com.lls.service;

/**
 * @author liuzheng
 * @since 13:22 2020/6/6
 */
public interface KafkaMsgService {

    void send();

    void insertMessage(int i);
}
