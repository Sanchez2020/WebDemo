package com.lei.demo.repository;

import com.lei.demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chris
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
