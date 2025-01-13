package com.practice.connectOpenAI.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ChatGPTRequest {
    private String model = "gpt-3.5-turbo";
    private List<ChatGPTMessages> messages;
    private Double temperature = 0.5;

    @SerializedName(value="max_tokens")
    private Integer maxTokens = 400;


}
