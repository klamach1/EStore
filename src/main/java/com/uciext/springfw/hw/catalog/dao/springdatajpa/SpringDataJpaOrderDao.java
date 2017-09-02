package com.uciext.springfw.hw.catalog.dao.springdatajpa;

import com.uciext.springfw.hw.catalog.dao.OrderDao;
import com.uciext.springfw.hw.catalog.model.Order;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SpringDataJpaOrderDao extends OrderDao, Repository<Order, Integer>{

    List<Order> findOrdersByUser(String user);

    void save(Order order);

    Order saveAndFlush(Order order);
}
