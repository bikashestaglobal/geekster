package com.geekster.awsmysql.controller;


import com.geekster.awsmysql.dto.BlogPostRequest;
import com.geekster.awsmysql.model.Post;
import com.geekster.awsmysql.service.BlogPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogPost")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    // create blog post
    @PostMapping("")
    public Post createBlogPost (@Valid @RequestBody BlogPostRequest blogPostRequest){
        return blogPostService.createBlogPost(blogPostRequest);
    }

    // getAllBLogPosts
    @GetMapping("")
    public List<Post> getAllBLogPosts (){
        return  blogPostService.getAllBlogPost();
    }

}
