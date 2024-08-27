package tn.essat.nlpchatbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.json.JSONArray;

@Service
public class GPT3Service {

    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    public String getChatbotResponse(String userInput) {
        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        // Create the request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-3.5-turbo");

        // Add the user's message
        JSONArray messages = new JSONArray();
        JSONObject userMessage = new JSONObject();
        userMessage.put("role", "user");
        userMessage.put("content", userInput);
        messages.put(userMessage);

        requestBody.put("messages", messages);

        // Make the request
        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);

        // Parse the response
        JSONObject jsonResponse = new JSONObject(response.getBody());
        JSONArray choices = jsonResponse.getJSONArray("choices");
        String gptResponse = choices.getJSONObject(0).getJSONObject("message").getString("content");

        return gptResponse;
    }
}
