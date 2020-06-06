package com.lls.common;

import com.alibaba.dubbo.common.threadpool.support.eager.TaskQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzheng
 * @since 16:17 2020/5/20
 */
public interface CommonConstants {
    String QUEUE_FANOUT_A = "Fanout.A";
    String QUEUE_FANOUT_B = "Fanout.B";
    String QUEUE_FANOUT_C = "Fanout.C";
    String EXCHANGE_FANOUT = "fanoutExchange";

    String KAFKA_TOPIC = "abc123";

    ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(1000, 1000, 1000, TimeUnit.MINUTES, new TaskQueue<>(1000));
}
