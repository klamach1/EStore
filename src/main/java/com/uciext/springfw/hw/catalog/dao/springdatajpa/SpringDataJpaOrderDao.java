package com.uciext.springfw.hw.catalog.dao.springdatajpa;

import com.uciext.springfw.hw.catalog.dao.OrderDao;
import com.uciext.springfw.hw.catalog.model.Order;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SpringDataJpaOrderDao extends OrderDao, Repository<Order, Integer>{

    public List<Order> findOrdersByUser(String user);
}
