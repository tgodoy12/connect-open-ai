package com.practice.connectOpenAI.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ChatGPTResponse {
      // Usa @JsonProperty para asegurarte del mapeo correcto.
    private List<ChatGPTChoice> choices;
}

