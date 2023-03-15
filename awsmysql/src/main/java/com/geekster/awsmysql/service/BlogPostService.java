package com.geekster.awsmysql.service;

import com.geekster.awsmysql.dao.BlogPostRepository;
import com.geekster.awsmysql.dto.BlogPostRequest;
import com.geekster.awsmysql.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    // createBlogPost
    public Post createBlogPost(BlogPostRequest blogPostRequest){
        Post post = Post.build(0,blogPostRequest.getTitle(), blogPostRequest.getDescription(), null, null);
        return blogPostRepository.save(post);
    }

    // getAllBlogPost
    public List<Post> getAllBlogPost(){
        return blogPostRepository.findAll();
    }
}
