package tn.essat.nlpchatbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.essat.nlpchatbot.entity.Adherent;
import tn.essat.nlpchatbot.entity.MaladeEnCharge;
import tn.essat.nlpchatbot.repository.MaladeEnChargeRepository;
import tn.essat.nlpchatbot.service.MaladeEnChargeService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MaladeEnChargeServiceImp implements MaladeEnChargeService {

    @Autowired
    private MaladeEnChargeRepository repository;

    @Override
    public MaladeEnCharge getMaladeEnChargeById(long id) {
        return repository.findById(id).orElse(null);
    }

    public MaladeEnCharge addMaladeEnCharge(MaladeEnCharge maladeEnCharge) {
        return repository.save(maladeEnCharge);
    }

    public void deleteMaladeEnCharge(long id) {
        repository.deleteById(id);
    }

    public MaladeEnCharge updateMaladeEnCharge(MaladeEnCharge maladeEnCharge) {
        return repository.save(maladeEnCharge);
    }

    @Override
    public List<MaladeEnCharge> getAllMaladesEnCharge() {
        return repository.findAll();
    }

    public Adherent getAdherentByMaladeEnChargeId(long id) {
        return repository.findAdherentByMaladeEnChargeId(id);
    }

    public List<MaladeEnCharge> getAllMaladesEnChargeByAdherentMatricule(long matricule_adherent) {
        return repository.findAllMaladesEnChargeByAdherentMatricule(matricule_adherent);
    }
}
