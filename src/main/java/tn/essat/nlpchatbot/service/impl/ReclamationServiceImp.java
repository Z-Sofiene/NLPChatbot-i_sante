package tn.essat.nlpchatbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.essat.nlpchatbot.entity.Dossier;
import tn.essat.nlpchatbot.entity.Reclamation;
import tn.essat.nlpchatbot.repository.ReclamationRepository;
import tn.essat.nlpchatbot.service.DossierService;
import tn.essat.nlpchatbot.service.ReclamationService;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReclamationServiceImp implements ReclamationService {
    
    @Autowired
    private ReclamationRepository repositoryReclamation;
    @Autowired
    private DossierService dossierService;
    
    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return repositoryReclamation.save(reclamation);
    }

    @Override
    public void deleteReclamationById(long id_reclamation) {
    	repositoryReclamation.deleteById(id_reclamation);
    }
    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return repositoryReclamation.save(reclamation);
    }

    @Override
    public Reclamation getReclamationById(long id_reclamation) {
        return repositoryReclamation.findById(id_reclamation).orElse(null);
    }

    @Override
    public Reclamation getReclamationByDossierId(long num_consultation) {
        return repositoryReclamation.findByDossierId(num_consultation);
    }

    @Override
    public List<Reclamation> getAllReclamationsByAdherentId(long matricule_adherent) {
        return repositoryReclamation.findAllByAdherentId(matricule_adherent);
    }
    @Override
    public List<Reclamation> getAllReclamations() {
        return repositoryReclamation.findAll();
    }


    // meme que getAllReclamationsByAdherentId(long matricule_adherent)
    @Override
    public List<Reclamation> getAllByAdherentMatricule(long matricule_adherent) {
        List<Dossier> listDossier = dossierService.getAllDossiersByAdherentMatricule(matricule_adherent);
        List<Reclamation> listReclamation = new ArrayList<Reclamation>();
        for (Dossier dossier : listDossier) {
            listReclamation.add(getReclamationByDossierId(dossier.getNumConsultation()));
        }
        return listReclamation;
    }
}
