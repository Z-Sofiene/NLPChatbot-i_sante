package tn.essat.nlpchatbot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.essat.nlpchatbot.entity.Adherent;
import tn.essat.nlpchatbot.entity.MaladeEnCharge;
import tn.essat.nlpchatbot.repository.MaladeEnChargeRepository;


public interface MaladeEnChargeService {

    MaladeEnCharge getMaladeEnChargeById(long id);

    MaladeEnCharge addMaladeEnCharge(MaladeEnCharge maladeEnCharge);

    void deleteMaladeEnCharge(long id);

    MaladeEnCharge updateMaladeEnCharge(MaladeEnCharge maladeEnCharge);

    List<MaladeEnCharge> getAllMaladesEnCharge();

    Adherent getAdherentByMaladeEnChargeId(long id);

    List<MaladeEnCharge> getAllMaladesEnChargeByAdherentMatricule(long matricule_adherent);


}
