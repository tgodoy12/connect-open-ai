package com.practice.connectOpenAI.models;

import lombok.Data;

@Data
public class ChatGPTMessages {
    private String role;
    private String content;

    public ChatGPTMessages(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
