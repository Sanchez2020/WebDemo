package com.lei.demo.domain;

import javax.persistence.*;

/**
 * 大小字典表
 * @author Chris
 */
@Entity
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue
    @Column(name = "size_id")
    private Integer id;         //号码（大小）id

    @Column(unique = true)
    private Integer size;       //大小描述

    public Size() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
