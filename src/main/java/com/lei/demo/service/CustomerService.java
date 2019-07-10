package com.lei.demo.service;

import com.lei.demo.domain.Customer;

import java.util.List;

/**
 * @author Chris
 */
public interface CustomerService {

    List<Customer> getCustomerList();

    Customer findCustomerById(Integer id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
