package com.lei.demo.serviceImpl;

import com.lei.demo.domain.Customer;
import com.lei.demo.repository.CustomerRepository;
import com.lei.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chris
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findOne(id);
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer id) {
        customerRepository.delete(id);
    }
}
