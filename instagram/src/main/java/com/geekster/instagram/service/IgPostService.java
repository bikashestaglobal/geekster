package com.geekster.instagram.service;

import com.geekster.instagram.dao.IgPostRepository;
import com.geekster.instagram.dao.UserRepository;
import com.geekster.instagram.dto.RequestIgPost;
import com.geekster.instagram.model.IgPost;
import com.geekster.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IgPostService {

    @Autowired
    private IgPostRepository igPostRepository;

    @Autowired
    private UserRepository userRepository;


    // createIgPost
    public Map<Object, Object> createIgPost(RequestIgPost igPostRequest) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();
        User user = userRepository.findById(igPostRequest.getUserId()).get();

        IgPost igPost = IgPost.build(null,user,igPostRequest.getContent(),null,null);
        igPost.setUser(user);
        IgPost savedIgPost = igPostRepository.save(igPost);

        resMap.put("body", savedIgPost);
        return resMap;
    }

    // getAllPosts
    public Map<Object, Object> getAllPosts() throws Exception{
        Map<Object, Object> resMap = new HashMap<>();
        List<IgPost> igPost = igPostRepository.findAll();
        resMap.put("body", igPost);
        return resMap;
    }

    // getPostById
    public Map<Object, Object> getPostById(int id) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();
        IgPost igPost = igPostRepository.findById(id).get();
        resMap.put("body", igPost);
        return resMap;
    }

    // getMyPosts
    public List<IgPost> getMyPosts(int id) throws Exception{
//        Map<Object, Object> resMap = new HashMap<>();
//        List<IgPost> igPosts = igPostRepository.getUserPosts(id);
//        resMap.put("body", igPosts);
        return igPostRepository.getUserPosts(id);
    }

}
