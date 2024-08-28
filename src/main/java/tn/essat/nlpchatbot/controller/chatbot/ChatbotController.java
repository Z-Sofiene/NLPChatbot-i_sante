package tn.essat.nlpchatbot.controller.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import tn.essat.nlpchatbot.service.GPT3Service;
import tn.essat.nlpchatbot.service.Pipeline;
import tn.essat.nlpchatbot.service.WebService;

import java.util.Set;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @Autowired
    private GPT3Service gpt3Service;

    @Autowired
    private Pipeline pipeline;

    @Autowired
    private WebService webService;

    @GetMapping("/ask")
    public String chatbotForm(Model model) {
        return "chatbot";
    }

    @PostMapping("/ask")
    public String processChatbotRequest(@RequestParam("userInput") String userInput, Model model) {
        // Call GPT-3 API to get response
        String gpt3Response = gpt3Service.getChatbotResponse(userInput);

        // Process the response using Stanford CoreNLP
        Set<String> entities = pipeline.extractEntities(gpt3Response);

        // Call the WebService to match and call the endpoint
        String webServiceResponse = webService.matchAndCallEndpoint(entities);

        model.addAttribute("response", webServiceResponse);
        return "chatbot";
    }
}