package com.lei.demo.service;

import com.lei.demo.domain.Order;
import com.lei.demo.domain.OrderItem;

import java.util.List;

/**
 * @author Chris
 */
public interface OrdersService {

    List<Order> getOrdersList();

    Order findOrdersById(String id);

    Order saveOrders(Order order);

    void deleteOrders(String id);

    List<OrderItem> getOrderItems(String id);

    List<Integer> getCustomerId();

}
