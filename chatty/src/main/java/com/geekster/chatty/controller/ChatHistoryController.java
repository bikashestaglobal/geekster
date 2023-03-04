package com.geekster.chatty.controller;

import com.geekster.chatty.dto.ChatHistoryRequest;
import com.geekster.chatty.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/chats")
public class ChatHistoryController {
    @Autowired
    private ChatHistoryService chatHistoryService;

    // createChat
    @PostMapping("")
    public ResponseEntity<Object> createChat(@Valid @RequestBody ChatHistoryRequest chatHistoryRequest){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = chatHistoryService.createChat(chatHistoryRequest);
        if(serviceResponse.containsKey("message")){
            errorObj.put("error", serviceResponse.get("message"));
            resObj.put("status", HttpStatus.BAD_REQUEST);
            resObj.put("message", "Oops Error occurred !");
            resObj.put("error", errorObj);
            return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
        }else{
            resObj.put("body", serviceResponse.get("body"));
            resObj.put("status", HttpStatus.CREATED);
            resObj.put("message", "Message send Successfully !");
            return new ResponseEntity<>(resObj, HttpStatus.CREATED);
        }
    }

    // chatHistoryRepository
    @PostMapping("/getMessage")
    public ResponseEntity<Object> getChatBetweenTwoUsers(@Valid @RequestBody ChatHistoryRequest chatHistoryRequest){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = chatHistoryService.getChatBetweenTwoUsers(chatHistoryRequest);
        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.CREATED);
        resObj.put("message", "Message send Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }


}
