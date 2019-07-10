package com.lei.demo.serviceImpl;

import com.lei.demo.domain.Order;
import com.lei.demo.domain.OrderItem;
import com.lei.demo.repository.OrderItemRepository;
import com.lei.demo.repository.OrdersRepository;
import com.lei.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chris
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<Order> getOrdersList() {
        return ordersRepository.findAll();
    }

    @Override
    public Order findOrdersById(String id) {
        return ordersRepository.findOne(id);
    }

    @Override
    @Transactional
    public Order saveOrders(Order order) {
        return ordersRepository.save(order);
    }

    @Override
    @Transactional
    public void deleteOrders(String id) {
        ordersRepository.delete(id);
    }

    @Override
    public List<OrderItem> getOrderItems(String id) {
        return orderItemRepository.findOrderItemsByOrder_Id(id);
    }

    @Override
    public List<Integer> getCustomerId() {
        return ordersRepository.findCustomerId();
    }
}
