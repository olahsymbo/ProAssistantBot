package com.proassistant.ProAssistant.controllers;

import com.proassistant.ProAssistant.entities.ChatBotRequest;
import com.proassistant.ProAssistant.entities.ChatBotResponse;
import com.proassistant.ProAssistant.entities.Message;
//import com.proassistant.ProAssistant.services.AssistantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ContentGenerationController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.max-completions}")
    private int maxCompletions;

    @Value("${openai.temperature}")
    private double temperature;

    @Value("${openai.max_tokens}")
    private int maxTokens;

    public ChatBotRequest chat(String prompt) {

        ChatBotRequest request = new ChatBotRequest(model,
                List.of(new Message("user", prompt)),
                maxCompletions,
                temperature,
                maxTokens);

        return request;
    }

    @GetMapping("/generate-content")
    public String showGenerateContentForm() {
        return "generateContentForm";
    }

    @PostMapping("/generate-content")
    public String chat(@RequestParam("prompt") String prompt, Model model) {

        ChatBotRequest request = chat(prompt);
        System.out.println(request);
        ChatBotResponse response = restTemplate.postForObject(apiUrl, request, ChatBotResponse.class);
        model.addAttribute("content", response);
        return "generatedContent";
    }
}

