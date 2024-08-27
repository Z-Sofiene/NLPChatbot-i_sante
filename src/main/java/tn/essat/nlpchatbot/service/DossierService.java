package tn.essat.nlpchatbot.service;

import java.util.List;
import java.util.Optional;

import tn.essat.nlpchatbot.entity.Dossier;


public interface DossierService {
    List<Dossier> getAllDossiersByMaladeEnChargeId(long id_malade_en_charge);
    Dossier findById(Long id);
    Optional<Dossier> getDossierByNumConsultation(long numConsultation);
    List<Dossier> getAllDossiersByAdherentMatricule(long matricule);
    Dossier addDossier(Dossier dossier);
    void deleteDossierByNumConsultation(long numConsultation);
    Dossier updateDossier(Dossier dossier);
}

