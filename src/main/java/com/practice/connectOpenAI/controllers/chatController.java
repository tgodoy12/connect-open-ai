package com.practice.connectOpenAI.controllers;

import com.practice.connectOpenAI.models.ChatInput;
import com.practice.connectOpenAI.services.ChatGPTService;
import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/chatgpt")
public class chatController {

    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatInput chatInput) {

        String response = chatGPTService.processMessage(chatInput.getChatInput());
        log.info(response);
        return ResponseEntity.ok(response);
    }

    /*
    @GetMapping("/prompt")
    public ChatResponse prompt(@RequestParam String message) {

        Integer maxTokens = 400;


        String model = "text-davinci-003";

        Double temperature = 0.5;

        Double topP = 1.0;

        ChatRequest chatRequest = new ChatRequest(model, message, maxTokens, temperature, topP);
        ChatResponse chatResponse = chatgptService.sendChatRequest(chatRequest);

        System.out.println("Respuesta: " + chatResponse.toString());

        return chatResponse;
    }
    */
}
