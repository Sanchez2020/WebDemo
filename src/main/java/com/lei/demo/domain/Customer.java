package com.lei.demo.domain;

import javax.persistence.*;

/**
 * 顾客实体类
 * @author Chris
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Integer id;         //顾客id

    private String name;        //顾客姓名

    private Integer gender;     //顾客性别，0表示男，1表示女

    @Column(length = 11)
    private String mobile;      //顾客联系方式

    private String address;     //顾客收货地址

    public Customer() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
