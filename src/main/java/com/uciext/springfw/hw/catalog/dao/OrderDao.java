package com.uciext.springfw.hw.catalog.dao;

import com.uciext.springfw.hw.catalog.model.Order;

import java.util.List;

public interface OrderDao {

    public List<Order> findOrdersByUser(String user);

}
