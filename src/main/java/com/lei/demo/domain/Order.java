package com.lei.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单实体类
 * @author Chris
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "orderId")
    @GenericGenerator(name = "orderId", strategy = "assigned")
    @Column(name = "order_id", length = 10)
    private String id;      //订单编号，主键

    @Column(name = "date")
    private Date date;  //订购时间

    @Column(name = "status")
    private Integer status;      //订单状态，0表示未完成，1表示已完成

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;      //每单对应一个顾客

    public Order() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                '}';
    }
}
