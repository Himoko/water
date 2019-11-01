package com.himoko.order.controller;

import com.himoko.order.pojo.Order;
import com.himoko.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @description: 订单
 * @author: peng.zhang11@ucarinc.com
 * @create: 2019-11-01 14:11
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getOrder")
    public List<Order> getOrder() {
        return orderService.getUser();
    }
}
