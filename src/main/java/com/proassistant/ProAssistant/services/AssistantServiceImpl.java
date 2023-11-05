//package com.proassistant.ProAssistant.services;
//
//import com.proassistant.ProAssistant.entities.ChatBotRequest;
//import com.proassistant.ProAssistant.entities.Message;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AssistantServiceImpl {
//
//    @Value("${openai.model}")
//    private String model;
//
//    @Value("${openai.max-completions}")
//    private int maxCompletions;
//
//    @Value("${openai.temperature}")
//    private double temperature;
//
//    @Value("${openai.max_tokens}")
//    private int maxTokens;
//
//    @Value("${openai.api.url}")
//    private String apiUrl;
//
//    public ChatBotRequest chat(String prompt) {
//
//        ChatBotRequest request = new ChatBotRequest(model,
//                List.of(new Message("user", prompt)),
//                maxCompletions,
//                temperature,
//                maxTokens);
//
//        return request;
//    }
//}
