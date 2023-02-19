package com.geekster.onlineshopping.dao;

import com.geekster.onlineshopping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
