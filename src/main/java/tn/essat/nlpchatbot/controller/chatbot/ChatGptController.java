package tn.essat.nlpchatbot.controller.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import tn.essat.nlpchatbot.component.OpenAiApiClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.essat.nlpchatbot.dto.CompletionRequest;
import tn.essat.nlpchatbot.dto.CompletionResponse;
import tn.essat.nlpchatbot.dto.FormInputDTO;


@RestController
@RequestMapping("/api/gpt3")
public class ChatGptController {
	
	// private static final String MAIN_PAGE = "index";
	
	@Autowired private ObjectMapper jsonMapper;
	@Autowired private OpenAiApiClient client;
	
	private String chatWithGpt3(String message) throws Exception {
		var completion = CompletionRequest.defaultWith(message);
		var postBodyJson = jsonMapper.writeValueAsString(completion);
		var responseBody = client.postToOpenAiApi(postBodyJson, OpenAiApiClient.OpenAiService.GPT_3);
		var completionResponse = jsonMapper.readValue(responseBody, CompletionResponse.class);
		return completionResponse.firstAnswer().orElseThrow();
	}

	@GetMapping
	public String index() {
		return "redirect:gpt3chat.html";
	}
	
	@PostMapping
	public String chat(Model model, @ModelAttribute FormInputDTO dto) {
		try {
			model.addAttribute("request", dto.prompt());
			model.addAttribute("response", chatWithGpt3(dto.prompt()));
		} catch (Exception e) {
			model.addAttribute("response", "Error in communication with OpenAI ChatGPT API.");
		}
		return "/api/gpt3";
	}
	@PostMapping("/model")
	public String model(Model model, @ModelAttribute FormInputDTO dto) {
		try {
			model.addAttribute("request", dto.prompt());
			model.addAttribute("response", chatWithGpt3(dto.prompt()));
		} catch (Exception e) {
			model.addAttribute("response", "Error in communication with OpenAI ChatGPT API.");
		}
		return model.toString();
	}
	
}
