package com.geekster.valiation.dao;

import com.geekster.valiation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
