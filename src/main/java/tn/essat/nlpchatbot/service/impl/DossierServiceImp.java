package tn.essat.nlpchatbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.essat.nlpchatbot.entity.Adherent;
import tn.essat.nlpchatbot.entity.Dossier;
import tn.essat.nlpchatbot.entity.MaladeEnCharge;
import tn.essat.nlpchatbot.repository.DossierRepository;
import tn.essat.nlpchatbot.repository.MaladeEnChargeRepository;
import tn.essat.nlpchatbot.service.AdherentService;
import tn.essat.nlpchatbot.service.DossierService;
import tn.essat.nlpchatbot.service.MaladeEnChargeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DossierServiceImp implements DossierService {
    @Autowired
    private DossierRepository dossierRepository;
    @Autowired
    private MaladeEnChargeService maladeEnChargeService;

    @Override
    public List<Dossier> getAllDossiersByMaladeEnChargeId(long id_malade_en_charge) {
        return dossierRepository.findAllDossiersByMaladeEnChargeId(id_malade_en_charge);
    }
    @Override
    public Dossier findById(Long numConsultation) {
        return dossierRepository.findById(numConsultation).orElse(null);
    }

    @Override
    public Optional<Dossier> getDossierByNumConsultation(long numConsultation) {
        return Optional.ofNullable(dossierRepository.findById(numConsultation).orElse(null));
    }

    @Override
    public List<Dossier> getAllDossiersByAdherentMatricule(long matricule) {
        List<MaladeEnCharge> malades = maladeEnChargeService.getAllMaladesEnChargeByAdherentMatricule(matricule);
        List<Dossier> dossiers = new ArrayList<Dossier>();
        for (MaladeEnCharge m : malades) {
            dossiers.addAll(getAllDossiersByMaladeEnChargeId(m.getId()));
        }
        return dossiers;
    }


    @Override
    public Dossier addDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public void deleteDossierByNumConsultation(long numConsultation) {
        dossierRepository.deleteById(numConsultation);
    }

    @Override
    public Dossier updateDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }
}
