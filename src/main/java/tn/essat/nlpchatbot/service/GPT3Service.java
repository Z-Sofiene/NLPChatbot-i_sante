package tn.essat.nlpchatbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GPT3Service {
    @Value("${openai.api.key}")
    private String API_KEY;
    private static final String GPT3_API_URL = "https://api.openai.com/v1/chat/completions";

    public String getChatbotResponse(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(API_KEY);

        String requestBody = "{ \"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}] }";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // Make request to GPT-3 API
        String response = restTemplate.postForObject(GPT3_API_URL, request, String.class);

        // Parse the response and return the message content
        // Here you'd extract the generated text from the GPT response JSON
        return response;
    }
}
