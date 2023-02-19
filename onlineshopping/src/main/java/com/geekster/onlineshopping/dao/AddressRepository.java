package com.geekster.onlineshopping.dao;

import com.geekster.onlineshopping.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
