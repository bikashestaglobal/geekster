package com.geekster.chatty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatHistoryRequest {
    private String message;

    @NotNull
    private int senderId;

    @NotNull
    private int receiverId;
}
