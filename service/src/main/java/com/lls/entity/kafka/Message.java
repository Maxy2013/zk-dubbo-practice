package com.lls.entity.kafka;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuzheng
 * @since 13:19 2020/6/6
 */
public class Message implements Serializable {

    private long id;

    private Object msg;

    private Date sendTime;

    public Message(long id, Object msg, Date sendTime) {
        this.id = id;
        this.msg = msg;
        this.sendTime = sendTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
