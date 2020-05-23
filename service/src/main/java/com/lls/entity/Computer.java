package com.lls.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author liuzheng
 * @since 9:08 2020/3/16
 */
public class Computer implements Serializable {

    private String name;
    private BigDecimal size;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
