package com.geekster.chatty.dao;

import com.geekster.chatty.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
