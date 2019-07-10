package com.lei.demo.repository;

import com.lei.demo.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Chris
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> findOrderItemsByOrder_Id(String id);
}
