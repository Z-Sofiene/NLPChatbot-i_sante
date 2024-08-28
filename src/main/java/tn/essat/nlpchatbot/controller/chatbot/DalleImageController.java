package tn.essat.nlpchatbot.controller.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.essat.nlpchatbot.component.OpenAiApiClient;
import tn.essat.nlpchatbot.dto.FormInputDTO;
import tn.essat.nlpchatbot.dto.GenerationRequest;
import tn.essat.nlpchatbot.dto.GenerationResponse;


@Controller
@RequestMapping("/image")
public class DalleImageController {
	
	// public static final String IMAGE_PAGE = "image";
	
	@Autowired private ObjectMapper jsonMapper;
	@Autowired private OpenAiApiClient client;
	
	private String drawImageWithDallE(String prompt) throws Exception {
		var generation = GenerationRequest.defaultWith(prompt);
		var postBodyJson = jsonMapper.writeValueAsString(generation);
		var responseBody = client.postToOpenAiApi(postBodyJson, OpenAiApiClient.OpenAiService.DALL_E);
		var completionResponse = jsonMapper.readValue(responseBody, GenerationResponse.class);
		return completionResponse.firstImageUrl().orElseThrow();
	}
	
	@GetMapping
	public String paintImage() {
		return "redirect:image.html";
	}
	
	@PostMapping
	public String drawImage(Model model, FormInputDTO dto) throws Exception {
		model.addAttribute("request", dto.prompt());
		model.addAttribute("imageUri", drawImageWithDallE(dto.prompt()));
		return "image";
	}

}
