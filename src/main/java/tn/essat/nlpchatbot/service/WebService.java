package tn.essat.nlpchatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Service
public class WebService {

    @Autowired
    private RestTemplate restTemplate;

    public String matchAndCallEndpoint(Set<String> entities) {

        if (entities.contains("dossier")) {
            String dossierInfo = callDossierEndpoint();
            return dossierInfo;
        } else if (entities.contains("reclamation")) {
            String reclamationInfo = callReclamationEndpoint();
            return reclamationInfo;
        }
        // Handle more cases
        return "Sorry, I couldn't understand your request.";
    }

    private String callDossierEndpoint() {
        // Example call to a GET endpoint for dossier
        String url = "http://sof.i-sante.com:10000/showDossiers/{matricule}";
        return restTemplate.getForObject(url, String.class, "12345"); // Example matricule
    }

    private String callReclamationEndpoint() {
        // Example call to a GET endpoint for reclamations
        String url = "http://sof.i-sante.com:10000/showReclamations/{uid}";
        return restTemplate.getForObject(url, String.class, "12345"); // Example UID
    }
}

