package tn.essat.nlpchatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tn.essat.nlpchatbot.entity.MaladeEnCharge;
import tn.essat.nlpchatbot.service.AdherentService;
import tn.essat.nlpchatbot.service.MaladeEnChargeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/malades_en_charge")
public class MaladeEnChargeController {

    @Autowired
    private MaladeEnChargeService maladeEnChargeService;
    private AdherentService adherentService;

    @PostMapping("/add")
    public ResponseEntity<MaladeEnCharge> createMaladeEnCharge(MultiValueMap<String, String> formData) {

        MaladeEnCharge maladeEnCharge = new MaladeEnCharge();

        maladeEnCharge.setNom(formData.getFirst("nom"));
        maladeEnCharge.setPrenom(formData.getFirst("prenom"));
        maladeEnCharge.setCIN(formData.getFirst("cin"));
        maladeEnCharge.setQualite(formData.getFirst("qualite"));
        maladeEnCharge.setAdherent(adherentService.getAdherentById(Long.parseLong(formData.getFirst("adherentId"))).orElse(null));

        return ResponseEntity.status(HttpStatus.CREATED).body(maladeEnChargeService.addMaladeEnCharge(maladeEnCharge));
    }

    @GetMapping
    public String listMaladesEnCharge(Model model) {
        List<MaladeEnCharge> maladesEnCharge = maladeEnChargeService.getAllMaladesEnChargeByAdherentMatricule(0); // replace 0 with the actual adherent ID
        model.addAttribute("maladesEnCharge", maladesEnCharge);
        return "redirect:list_malades_en_charge.html"; // Thymeleaf template name
    }

    @PostMapping("/delete")
    public String deleteMaladeEnCharge(@RequestParam("id") long id, RedirectAttributes redirectAttributes) {
        Optional<MaladeEnCharge> maladeEnCharge = Optional.ofNullable(maladeEnChargeService.getMaladeEnChargeById(id));
        if (maladeEnCharge.isPresent()) {
            maladeEnChargeService.deleteMaladeEnCharge(id);
            redirectAttributes.addFlashAttribute("message", "MaladeEnCharge deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "MaladeEnCharge not found!");
        }
        return "redirect:/malades_en_charge";
    }
}
