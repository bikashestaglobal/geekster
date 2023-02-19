package com.geekster.onlineshopping.dao;

import com.geekster.onlineshopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
