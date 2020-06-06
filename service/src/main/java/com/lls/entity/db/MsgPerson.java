package com.lls.entity.db;


import java.io.Serializable;
import java.util.Date;

/**
 * @author liuzheng
 * @since 15:21 2020/6/6
 */
public class MsgPerson implements Serializable {

    private long id;

    private String name;

    private int age;

    private String address;

    private double salary;

    private char status = '0';

    private Date createTime;

    private Date modifyTime;

    public MsgPerson() {
    }

    public MsgPerson(long id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public MsgPerson(long id, String name, int age, String address, Date createTime, Date modifyTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
