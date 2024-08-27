package tn.essat.nlpchatbot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.essat.nlpchatbot.entity.Adherent;
@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {
    @Query("select a from Adherent a")
    List<Adherent> findAllAdherents();
    @Query("select a from Adherent a where a.username=?1")
    Optional<Adherent> findByUsername(String username);

}
