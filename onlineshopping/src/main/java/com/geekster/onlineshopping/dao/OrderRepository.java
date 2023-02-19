package com.geekster.onlineshopping.dao;

import com.geekster.onlineshopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
