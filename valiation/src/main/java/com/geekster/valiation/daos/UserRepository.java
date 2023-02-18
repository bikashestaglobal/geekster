package com.geekster.valiation.daos;

import com.geekster.valiation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
