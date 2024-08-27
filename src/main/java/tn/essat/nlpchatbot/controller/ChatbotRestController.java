package tn.essat.nlpchatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.essat.nlpchatbot.dto.ChatbotRequest;
import tn.essat.nlpchatbot.dto.ChatbotResponse;
import tn.essat.nlpchatbot.service.GPT3Service;


@RestController
@RequestMapping("/api/chatbot")
public class ChatbotRestController {

    @Autowired
    private GPT3Service gpt3Service;

    @PostMapping("/message")
    public ResponseEntity<ChatbotResponse> processMessage(@RequestBody ChatbotRequest chatbotRequest) {
        String userMessage = chatbotRequest.getMessage();
        String gptResponse = gpt3Service.getChatbotResponse(userMessage);

        ChatbotResponse response = new ChatbotResponse(gptResponse);
        return ResponseEntity.ok(response);
    }
}