package tn.essat.nlpchatbot.service;

import java.util.List;

import tn.essat.nlpchatbot.entity.Reclamation;

public interface ReclamationService {

    Reclamation addReclamation(Reclamation reclamation);

    void deleteReclamationById(long id_reclamation);

    Reclamation updateReclamation(Reclamation reclamation);

    Reclamation getReclamationById(long id_reclamation);

    Reclamation getReclamationByDossierId(long num_consultation);

    List<Reclamation> getAllReclamationsByAdherentId(long matricule_adherent);

    List<Reclamation> getAllReclamations();
    List<Reclamation> getAllByAdherentMatricule(long matricule_adherent);

}

