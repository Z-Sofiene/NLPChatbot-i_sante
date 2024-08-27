package tn.essat.nlpchatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.essat.nlpchatbot.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}