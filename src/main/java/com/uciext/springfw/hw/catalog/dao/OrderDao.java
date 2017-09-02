package com.uciext.springfw.hw.catalog.dao;

import com.uciext.springfw.hw.catalog.model.Order;

import java.util.List;

public interface OrderDao {

    List<Order> findOrdersByUser(String user);

    void save(Order order);

    Order saveAndFlush(Order order);

}
