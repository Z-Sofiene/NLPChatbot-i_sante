package tn.essat.nlpchatbot.controller.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.essat.nlpchatbot.service.GPT3ClientService;

import java.io.IOException;

@RestController
@RequestMapping("/api/gpt3client")
public class GPT3ClientRestController {

    @Autowired
    public GPT3ClientService gpt3Client;

    @PostMapping("/chat/{message}")
    public String getResponse(@PathVariable String message) throws IOException, InterruptedException {
        String response = gpt3Client.callGpt3Api(message);
        return response;
    }
}