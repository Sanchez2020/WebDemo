package com.lei.demo.domain;

import javax.persistence.*;

/**
 * 订单项实体表
 * @author Chris
 */
@Entity
@Table(name = "orderItem")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "orderItem_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shoes_id")
    private Shoes shoes;    //具体订单项

    private Integer quantity;   //数量

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;        //所属订单

    public OrderItem() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", shoes=" + shoes +
                ", quantity=" + quantity +
                ", order=" + order +
                '}';
    }
}
