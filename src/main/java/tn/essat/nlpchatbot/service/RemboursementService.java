package tn.essat.nlpchatbot.service;

import java.util.List;

import tn.essat.nlpchatbot.entity.Remboursement;

public interface RemboursementService {

    Remboursement addRemboursement(Remboursement remboursement);
    Remboursement updateRemboursement(Remboursement remboursement);
    Remboursement getRemboursementById(long id_remboursement);

    Remboursement getRemboursementByTiersPayantId (long num_transaction);

    List<Remboursement> getAllRemboursements();
    List<Remboursement> getAllRemboursementsByDossierId(long num_consultation);

    void deleteRemboursementById(long id_remboursement);

}

