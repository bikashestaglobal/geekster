package com.geekster.chatty.service;

import com.geekster.chatty.dao.ChatHistoryRepository;
import com.geekster.chatty.dao.UserRepository;
import com.geekster.chatty.dto.ChatHistoryRequest;
import com.geekster.chatty.model.ChatHistory;
import com.geekster.chatty.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ChatHistoryService {
    @Autowired
    private ChatHistoryRepository chatHistoryRepository;
    @Autowired
    private UserRepository userRepository;

    // createChat
    public Map<Object, Object> createChat(ChatHistoryRequest chatRequest) throws NoSuchElementException {
        Map<Object, Object> resMap = new HashMap();
        User sender = userRepository.findById(chatRequest.getSenderId()).get();
        User receiver = userRepository.findById(chatRequest.getReceiverId()).get();
        ChatHistory newChatHistory = ChatHistory.build(null, sender,receiver, chatRequest.getMessage(),null,null);

        resMap.put("body", chatHistoryRepository.save(newChatHistory));
        return resMap;
    }

    // createChatBetweenTwoUsers
    public Map<Object, Object> getChatBetweenTwoUsers(ChatHistoryRequest chatRequest) throws NoSuchElementException {
        Map<Object, Object> resMap = new HashMap();
        User sender = userRepository.findById(chatRequest.getSenderId()).get();
        User receiver = userRepository.findById(chatRequest.getReceiverId()).get();
        List<ChatHistory> newChatHistoryList = chatHistoryRepository.getChatBetweenTwoUsers(chatRequest.getSenderId(), chatRequest.getReceiverId());

        resMap.put("body", newChatHistoryList);
        return resMap;
    }


}
