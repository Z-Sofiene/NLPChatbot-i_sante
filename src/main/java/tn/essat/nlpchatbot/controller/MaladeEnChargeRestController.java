package tn.essat.nlpchatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import tn.essat.nlpchatbot.entity.Adherent;
import tn.essat.nlpchatbot.entity.MaladeEnCharge;
import tn.essat.nlpchatbot.service.AdherentService;
import tn.essat.nlpchatbot.service.MaladeEnChargeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/malades-en-charge")
public class MaladeEnChargeRestController {

    @Autowired
    private MaladeEnChargeService maladeEnChargeService;
    private AdherentService adherentService;

    @GetMapping("/{id}")
    public ResponseEntity<MaladeEnCharge> getMaladeEnChargeById(@PathVariable long id) {
        Optional<MaladeEnCharge> maladeEnCharge = Optional.ofNullable(maladeEnChargeService.getMaladeEnChargeById(id)); // assuming a method to get by ID
        return maladeEnCharge.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<MaladeEnCharge>> listMaladesEnCharge() {
        List<MaladeEnCharge> maladesEnCharge = maladeEnChargeService.getAllMaladesEnCharge();
        return new ResponseEntity<>(maladesEnCharge, HttpStatus.OK);
    }

    @PostMapping
    public RedirectView createMaladeEnCharge(@RequestParam("nom") String nom,
                                             @RequestParam("prenom") String prenom,
                                             @RequestParam("cin") String cin,
                                             @RequestParam("qualite") String qualite,
                                             @RequestParam("matricule_adherent") long matricule_adherent,
                                             RedirectAttributes redirectAttributes) {

        Optional<Adherent> adherent = adherentService.getAdherentById(matricule_adherent);

        MaladeEnCharge maladeEnCharge = new MaladeEnCharge();

        maladeEnCharge.setNom(nom);
        maladeEnCharge.setPrenom(prenom);
        maladeEnCharge.setCIN(cin);
        maladeEnCharge.setQualite(qualite);
        maladeEnCharge.setAdherent(adherent.get());

        maladeEnChargeService.addMaladeEnCharge(maladeEnCharge);

        redirectAttributes.addFlashAttribute("message", "MaladeEnCharge added successfully!");

        return new RedirectView("/malades-en-charge");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaladeEnCharge(@PathVariable("id") long id) {
        Optional<MaladeEnCharge> maladeEnCharge = Optional.ofNullable(maladeEnChargeService.getMaladeEnChargeById(id)); // assuming a method to get by ID
        if (maladeEnCharge.isPresent()) {
            maladeEnChargeService.deleteMaladeEnCharge(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/adherent/{matricule}")
    public ResponseEntity<List<MaladeEnCharge>> getAllMaladesEnChargeByAdherentMatricule(@PathVariable("matricule") long matricule_adherent) {
        List<MaladeEnCharge> maladesEnCharge = maladeEnChargeService.getAllMaladesEnChargeByAdherentMatricule(matricule_adherent);
        return new ResponseEntity<>(maladesEnCharge, HttpStatus.OK);
    }

    @GetMapping("/{id}/adherent")
    public ResponseEntity<Adherent> getAdherentByMaladeEnChargeId(@PathVariable("id") long id) {
        Adherent adherent = maladeEnChargeService.getAdherentByMaladeEnChargeId(id);
        return ResponseEntity.ok(adherent);
    }
}
