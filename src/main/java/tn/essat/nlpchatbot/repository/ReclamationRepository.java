package tn.essat.nlpchatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.essat.nlpchatbot.entity.Reclamation;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

    @Query("select r from Reclamation r where r.dossier.num_consultation=?1")
    Reclamation findByDossierId(long numConsultation);

    /*
    @Query("SELECT r FROM Reclamation r " +
           "JOIN Dossier d ON r.dossier.num_consultation = d.num_consultation " +
           "JOIN MaladeEnCharge m ON d.malade_en_charge.id = m.id " +
           "JOIN Adherent a ON m.adherent.matricule = a.matricule " +
           "WHERE a.matricule = ?1")
     */
    @Query("SELECT r FROM Reclamation r " +
           "JOIN r.dossier d  " +
           "JOIN d.malade_en_charge m  " +
           "JOIN m.adherent a  " +
           "WHERE a.matricule = ?1")
    List<Reclamation> findAllByAdherentId(long matricule_adherent);

}

