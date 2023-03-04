package com.geekster.chatty.dao;

import com.geekster.chatty.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Integer> {

    @Query(value = "SELECT * FROM chat_history_tbl WHERE (sender_id=:senderId AND receiver_id=:receiverId) OR (sender_id=:receiverId AND receiver_id=:senderId) ORDER BY created_at DESC", nativeQuery = true)
    List<ChatHistory> getChatBetweenTwoUsers(int senderId, int receiverId);
}
