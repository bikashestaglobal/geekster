package com.geekster.chatty.dao;

import com.geekster.chatty.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Native Query
    @Query(value = "SELECT * FROM user_tbl WHERE email=:email AND status_id=1", nativeQuery = true)
    public User findByEmail(String email);
}
