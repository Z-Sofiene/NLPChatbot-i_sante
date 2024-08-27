package tn.essat.nlpchatbot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import tn.essat.nlpchatbot.entity.Dossier;
import tn.essat.nlpchatbot.repository.MaladeEnChargeRepository;
import tn.essat.nlpchatbot.service.DossierService;

@Controller
@RequestMapping("/dossiers")
public class DossierController {

    @Autowired
    private DossierService service;
    @Autowired
    private MaladeEnChargeRepository maladeEnChargeRepository;


    @GetMapping("/adherent/{matricule}")
    public String showDossiersByAdherent (Model model,@PathVariable long matricule) {
        List<Dossier> listDossiers = service.getAllDossiersByAdherentMatricule(matricule);
        model.addAttribute("dossiersByAdherent", listDossiers);
        return "redirect:list_dossiers.html";
    }

    @GetMapping("/malade_en_charge/{id}")
    public String showDossiersByMaladeEnCharge(Model model,@PathVariable long id) {
        List<Dossier> listDossiers = service.getAllDossiersByMaladeEnChargeId(id);
        model.addAttribute("dossiersByMaladeEnCharge", listDossiers);
        return "redirect:list_dossiers.html";
    }

    @PostMapping
    public Dossier addDossier(@RequestBody Dossier dossier) {
        return service.addDossier(dossier);
    }
    @PostMapping("/createDossier")
    public ResponseEntity<String> createDossier(@RequestBody Dossier dossier) {
    try {
        service.addDossier(dossier);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dossier ajouté avec succès!");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de l'ajout du dossier.");
    }
}
    @DeleteMapping("/{numConsultation}")
    public void deleteDossier(@PathVariable long numConsultation) {
        service.deleteDossierByNumConsultation(numConsultation);
    }

    @PutMapping
    public Dossier updateDossier(@RequestBody Dossier dossier) {
        return service.updateDossier(dossier);
    }
}

