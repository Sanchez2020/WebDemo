package com.lei.demo.controller;

import com.lei.demo.domain.Customer;
import com.lei.demo.service.CustomerService;
import com.lei.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制顾客管理页面跳转
 * @author Chris
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrdersService ordersService;

    /**
     * @Author: Chris
     * @Date: 14:27 2018/7/2
     * @Description: 跳转到顾客列表页面
     * @params:  * @param model
     */
    @GetMapping(value = "/customers")
    public String customerList(Model model) {
        List<Customer> customers = customerService.getCustomerList();
        List<Integer> customerList = ordersService.getCustomerId();
        model.addAttribute("customerList", customerList);
        model.addAttribute("customers", customers);
        return "customer/customerList";
    }

    /**
     * @Author: Chris
     * @Date: 14:28 2018/7/2
     * @Description: 跳转到添加顾客页面
     * @params:  * @param
     */
    @GetMapping(value = "/customer")
    public String customerToAdd() {
        return "customer/addCustomer";
    }

    /**
     * @Author: Chris
     * @Date: 14:29 2018/7/2
     * @Description: 添加一个顾客，跳转回顾客列表页面
     * @params:  * @param customer
     */
    @PostMapping(value = "/customer")
    public String addCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    /**
     * @Author: Chris
     * @Date: 14:29 2018/7/2
     * @Description: 跳转到编辑顾客页面
     * @params:  * @param id
     * @param model
     */
    @GetMapping(value = "/customer/{id}")
    public String customerToEdit(@PathVariable(value = "id") Integer id, Model model) {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer/addCustomer";
    }

    /**
     * @Author: Chris
     * @Date: 14:30 2018/7/2
     * @Description: 编辑一位顾客，跳转回顾客列表页面
     * @params:  * @param customer
     */
    @PutMapping(value = "/customer")
    public String editCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    /**
     * @Author: Chris
     * @Date: 14:31 2018/7/2
     * @Description: 删除一个顾客
     * @params:  * @param id
     */
    @DeleteMapping(value = "/customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
