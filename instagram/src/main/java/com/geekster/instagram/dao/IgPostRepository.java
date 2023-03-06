package com.geekster.instagram.dao;

import com.geekster.instagram.model.IgPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IgPostRepository extends JpaRepository<IgPost, Integer> {
    @Query(value = "SELECT * FROM ig_post_tbl WHERE user_id=:id", nativeQuery = true)
    public List<IgPost> getUserPosts(int id);
}
