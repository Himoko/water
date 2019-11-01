package com.himoko.order.dao;

import com.himoko.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    List<Order> getUser();
}
