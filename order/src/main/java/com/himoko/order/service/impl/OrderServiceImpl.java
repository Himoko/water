package com.himoko.order.service.impl;

import com.himoko.order.dao.OrderDao;
import com.himoko.order.pojo.Order;
import com.himoko.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @author: peng.zhang11@ucarinc.com
 * @create: 2019-11-01 14:11
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getUser() {
        return orderDao.getUser();
    }
}
