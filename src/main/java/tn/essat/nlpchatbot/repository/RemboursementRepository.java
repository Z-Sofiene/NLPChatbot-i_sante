package tn.essat.nlpchatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.essat.nlpchatbot.entity.Remboursement;

import java.util.List;

@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {

    @Query("select r from Remboursement r where r.tiers_payant.num_transaction=?1")
    Remboursement findByTiersPayantId (long num_transaction);

    @Query("SELECT r FROM Remboursement r " +
           "JOIN r.tiers_payant t " +
           "JOIN t.dossier d  " +
           "WHERE d.num_consultation = ?1")
    List<Remboursement> findAllByDossierID (long num_consultation);
}

