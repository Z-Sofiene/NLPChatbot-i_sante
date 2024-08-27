package tn.essat.nlpchatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.essat.nlpchatbot.entity.Reclamation;
import tn.essat.nlpchatbot.service.ReclamationService;


import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
public class ReclamationRestController {

    @Autowired
    private ReclamationService reclamationService;

    @PostMapping("/add")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }
    @GetMapping("/adherent/{matricule_adherent}")
    public List<Reclamation> showReclamationsByAdherent(@PathVariable long matricule_adherent) {
        return reclamationService.getAllReclamationsByAdherentId(matricule_adherent);
    }

}
