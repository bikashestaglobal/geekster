package com.geekster.chatty.dao;

import com.geekster.chatty.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Native Query
    @Query(value = "SELECT * FROM user_tbl WHERE first_name=:firstName", nativeQuery = true)
    public List<User> getUserByFirstName(String firstName);

    @Query(value = "SELECT * FROM user_tbl WHERE last_name=:lastName", nativeQuery = true)
    public List<User> getUserByLastName(String lastName);

    @Query(value = "SELECT * FROM user_tbl WHERE age=:age", nativeQuery = true)
    public List<User> getUserByAge(Integer age);

    @Query(value = "SELECT * FROM user_tbl WHERE admission_date=:admissionDate", nativeQuery = true)
    public List<User> getUserByAdmissionDate(Date admissionDate);

    @Query(value = "SELECT * FROM user_tbl WHERE active=:active", nativeQuery = true)
    public List<User> getUserByActive(Boolean active);

}
