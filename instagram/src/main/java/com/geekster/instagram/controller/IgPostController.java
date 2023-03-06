package com.geekster.instagram.controller;

import com.geekster.instagram.dto.RequestIgPost;
import com.geekster.instagram.model.IgPost;
import com.geekster.instagram.model.User;
import com.geekster.instagram.service.IgPostService;
import jakarta.validation.Valid;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
public class IgPostController {
    @Autowired
    private IgPostService igPostService;

    // createPost
    @PostMapping("")
    public Map<Object,Object> createIgPost(@Valid @RequestBody RequestIgPost requestIgPost) throws Exception {
        Map<Object, Object> serviceRes = igPostService.createIgPost(requestIgPost);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Post Created Successfully");
        resMap.put("status" , HttpStatus.OK);
        return resMap;
    }

    // getAllPosts
    @GetMapping("")
    public Map<Object,Object> getAllPosts() throws Exception {
        Map<Object, Object> serviceRes = igPostService.getAllPosts();
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Post Fetched Successfully");
        resMap.put("status" , HttpStatus.OK);
        return resMap;
    }

    // getAllPosts
    @GetMapping("/{id}")
    public Map<Object,Object> getPostById(@PathVariable int id) throws Exception {
        Map<Object, Object> serviceRes = igPostService.getPostById(id);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Post Fetched Successfully");
        resMap.put("status" , HttpStatus.OK);
        return resMap;
    }


    // getMyPosts
    @GetMapping("/userPosts/{id}")
    public ResponseEntity<String> getMyPosts(@PathVariable int id) throws Exception {
        List<IgPost> posts = igPostService.getMyPosts(id);
        JSONArray jsonArray = new JSONArray();

        JSONObject resObj = new JSONObject();

        posts.forEach(post->{
            JSONObject masterJson = new JSONObject();
            masterJson.put("id", post.getId());
            masterJson.put("content" , post.getContent());
            masterJson.put("createdAt" , post.getCreatedAt());
            masterJson.put("updatedAt" , post.getUpdatedAt());
            User user = post.getUser();
            JSONObject userJsonObj = new JSONObject();
            userJsonObj.put("userId", user.getId());
            userJsonObj.put("name" , user.getName());
            masterJson.put("user" , userJsonObj);
            jsonArray.put(masterJson);
        });

        resObj.put("body", jsonArray);
        resObj.put("message", "Post Fetched Successfully");
        resObj.put("status", HttpStatus.OK);

        return new ResponseEntity<>(resObj.toString(),HttpStatus.OK);
    }

}
