package tn.essat.nlpchatbot.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GPT3ClientService {
    private final String apiKey;
    private final String apiEndpoint;
    private final HttpClient httpClient;

    public GPT3ClientService(@Value("${ApiKey}") String apiKey, @Value("${ApiWebService}") String apiEndpoint) {
        this.apiKey = apiKey;
        this.apiEndpoint = apiEndpoint;
        this.httpClient = HttpClient.newHttpClient();
    }

    public String callGpt3Api(String prompt) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiEndpoint))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"prompt\": \"" + prompt + "\", \"model\": \"gpt3-5-turbo\"}"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}