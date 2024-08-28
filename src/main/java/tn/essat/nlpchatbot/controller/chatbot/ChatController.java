package tn.essat.nlpchatbot.controller.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.essat.nlpchatbot.service.GPT3Service;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private GPT3Service gpt3Service;

    @GetMapping("/chatpage")
    public String chatPage() {
        return "chat";
    }

    @PostMapping("/answer")
    public String getChatbotResponse(@RequestParam("message") String message, Model model) {
        String response = gpt3Service.getChatbotResponse(message);
        model.addAttribute("response", response);
        model.addAttribute("message", message);
        return "chat";
    }
}
