package tn.essat.nlpchatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.essat.nlpchatbot.entity.TiersPayant;
import java.util.List;
@Repository
public interface TiersPayantRepository extends JpaRepository<TiersPayant, Long> {
    @Query("SELECT t from TiersPayant t where t.dossier.num_consultation = ?1")
    List<TiersPayant> findByDossierId(long num_consultation);
}
