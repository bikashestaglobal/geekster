package com.geekster.awsmysql.dao;

import com.geekster.awsmysql.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<Post, Integer> {
}
