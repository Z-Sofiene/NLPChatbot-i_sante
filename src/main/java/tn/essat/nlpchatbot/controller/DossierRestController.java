package tn.essat.nlpchatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.essat.nlpchatbot.entity.Dossier;
import tn.essat.nlpchatbot.service.DossierService;

import java.util.List;

@RestController
@RequestMapping("/api/dossiers")
public class DossierRestController {
    @Autowired
    private DossierService service;


    @GetMapping("/malade/{idMalade}")
    public List<Dossier> getAllDossiersByMaladeEnChargeId(@PathVariable long idMalade) {
        return service.getAllDossiersByMaladeEnChargeId(idMalade);
    }

    @GetMapping("/showDossiers/malade_en_charge/{id}")
    public ResponseEntity<List<Dossier>> showDossiersByMaladeEnCharge(@PathVariable long id) {
        return new ResponseEntity<>(service.getAllDossiersByMaladeEnChargeId(id), HttpStatus.OK);
    }

    @GetMapping("/showDossiers/{matricule}")
    public ResponseEntity<List<Dossier>> showDossiersByAdherent(@PathVariable long matricule) {
        return new ResponseEntity<>(service.getAllDossiersByAdherentMatricule(matricule), HttpStatus.OK);
    }

    @PostMapping("/add")
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
