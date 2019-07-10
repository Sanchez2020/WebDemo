package com.lei.demo.repository;

import com.lei.demo.domain.Customer;
import com.lei.demo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Chris
 */
public interface OrdersRepository extends JpaRepository<Order, String> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT customer_id FROM orders")
    List<Integer> findCustomerId();
}
