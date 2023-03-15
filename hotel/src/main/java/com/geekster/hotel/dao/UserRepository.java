package com.geekster.hotel.dao;

import com.geekster.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
