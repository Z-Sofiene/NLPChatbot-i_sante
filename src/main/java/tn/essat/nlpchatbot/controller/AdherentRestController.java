package tn.essat.nlpchatbot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import tn.essat.nlpchatbot.entity.Adherent;
import tn.essat.nlpchatbot.entity.Enum.Role;
import tn.essat.nlpchatbot.service.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adherents")
public class AdherentRestController {

    @Autowired
    private AdherentService adherentService;

    @GetMapping("/{matricule}")
    public ResponseEntity<Adherent> getAdherentById(@PathVariable long matricule) {
        Optional<Adherent> adherent = adherentService.getAdherentById(matricule);
        return adherent.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Adherent>> listAdherents() {
        List<Adherent> adherents = adherentService.getAllAdherents();
        return new ResponseEntity<>(adherents, HttpStatus.OK);
    }

    @PostMapping
    public RedirectView createAdherent(@RequestParam("nom") String nom,
                                       @RequestParam("prenom") String prenom,
                                       @RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       @RequestParam("cin") String cin,
                                       @RequestParam("genre") String genre,
                                       @RequestParam("rib_rip") String rib_rip,
                                       @RequestParam("fiscale") String fiscale,
                                       @RequestParam("date_de_naissance") String date_de_naissance,
                                       @RequestParam("email") String email,
                                       @RequestParam("role") String role,
                                       RedirectAttributes redirectAttributes) {
        Adherent adherent = new Adherent();
        adherent.setUsername(username);
        adherent.setPassword(password);
        adherent.setCIN(cin);
        adherent.setNom(nom);
        adherent.setPrenom(prenom);
        adherent.setGenre(genre);
        adherent.setRIB_RIP(rib_rip);
        adherent.setMatricule_fiscale(fiscale);
        adherent.setDate_de_naissance(date_de_naissance);
        adherent.setEmail(email);
        adherent.setRole(Role.valueOf(role));

        adherentService.addAdherent(adherent);

        redirectAttributes.addFlashAttribute("message", "adherent added successfully!");

        return new RedirectView("/adherents");
    }

    @DeleteMapping("/{matricule}")
    public ResponseEntity<Void> deleteAdherent(@PathVariable long matricule) {
        Optional<Adherent> adherent = adherentService.getAdherentById(matricule);
        if (adherent.isPresent()) {
            adherentService.deleteAdherentById(matricule);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
