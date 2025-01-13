package com.practice.connectOpenAI.services;

import com.google.gson.Gson;
import com.practice.connectOpenAI.models.ChatGPTMessages;
import com.practice.connectOpenAI.models.ChatGPTRequest;
import com.practice.connectOpenAI.models.ChatGPTResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ChatGPTService {

    @Value("${OPEN_AI_URL}")
    private String OPEN_AI_URL;

    @Value("${OPEN_AI_KEY}")
    private String OPEN_AI_KEY;

    public String processMessage(String message) {

        // Crear el objeto de solicitud
        ChatGPTRequest chatGPTRequest = new ChatGPTRequest();


        // Crear una lista de mensajes para la solicitud
        List<ChatGPTMessages> messages = new ArrayList<>();
        messages.add(new ChatGPTMessages("user", message));  // El rol "user" es quien hace la pregunta
        chatGPTRequest.setMessages(messages);

        String url = OPEN_AI_URL;

        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + OPEN_AI_KEY.trim());

        Gson gson = new Gson();

        String body = gson.toJson(chatGPTRequest);

        log.info("URL: " + url);
        log.info("Authorization: Bearer " + OPEN_AI_KEY);
        log.info("Body: " + body);

        try {
            final StringEntity entity = new StringEntity(body);
            post.setEntity(entity);

            try (CloseableHttpClient httpClient = HttpClients.custom().build();
                 CloseableHttpResponse response = httpClient.execute(post)) {

                String responseBody = EntityUtils.toString(response.getEntity());
                log.info("Respuesta de la API: " + responseBody);

                // Deserializar la respuesta
                ChatGPTResponse chatGPTResponse = gson.fromJson(responseBody, ChatGPTResponse.class);
                //log.info(chatGPTResponse.getChoices().get(0).getText());
                //return chatGPTResponse.getChoices().get(0).getText();
                return responseBody;


            } catch (Exception e) {
                log.error("Error al realizar la solicitud a OpenAI", e);
                return "Ocurrió un error al procesar la solicitud.";
            }
        } catch (Exception e) {
            log.error("Error al preparar la solicitud", e);
            return "Error al preparar la solicitud.";
        }
    }
}


