package com.lei.demo.controller;

import com.lei.demo.domain.Customer;
import com.lei.demo.domain.Order;
import com.lei.demo.domain.OrderItem;
import com.lei.demo.domain.Shoes;
import com.lei.demo.service.CustomerService;
import com.lei.demo.service.OrdersService;
import com.lei.demo.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制订单管理页面跳转
 * @author Chris
 */
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * @Author: Chris
     * @Date: 14:33 2018/7/2
     * @Description: 跳转到订单列表页面
     * @params:  * @param model
     */
    @GetMapping(value = "/orders")
    public String ordersList(Model model) {
        List<Order> orders = ordersService.getOrdersList();
        model.addAttribute("orders", orders);
        return "orders/ordersList";
    }

//    @GetMapping(value = "/order")
//    public String ordersToAdd() {
//        return "orders/detailedOrders";
//    }

//    @PostMapping(value = "/order")
//    public String addOrders(Order order) {
//        ordersService.saveOrders(order);
//        return "redirect:/orders";
//    }

    /**
     * @Author: Chris
     * @Date: 14:34 2018/7/2
     * @Description: 跳转到订单详情页面
     * @params:  * @param id
     * @param model
     */
    @GetMapping(value = "/order/{id}")
    public String ordersToDetailed(@PathVariable(value = "id") String id, Model model) {
        Order order = ordersService.findOrdersById(id);

        /** 查找订单的所有订单项 */
        List<OrderItem> orderItems = ordersService.getOrderItems(id);

        /** 计算一个订单的总额 */
        Double sum = 0.0;
        for (OrderItem item : orderItems) {
            sum += item.getShoes().getProduct().getPrice() * item.getQuantity();
        }
        model.addAttribute("sum", sum);
        model.addAttribute("orderItems", orderItems);
        model.addAttribute("order", order);
        return "orders/detailedOrders";
    }

//    @PutMapping(value = "/order")
//    public String editOrders(Order order) {
//        ordersService.saveOrders(order);
//        return "redirect:/orders";
//    }

    /**
     * @Author: Chris
     * @Date: 14:34 2018/7/2
     * @Description: 删除一个订单
     * @params:  * @param id
     */
    @DeleteMapping(value = "/order/{id}")
    public String deleteOrders(@PathVariable(value = "id") String id) {
        ordersService.deleteOrders(id);
        return "redirect:/orders";
    }
}
