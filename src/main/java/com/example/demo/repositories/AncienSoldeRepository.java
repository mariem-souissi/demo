package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AncienSolde;
@Repository
public interface AncienSoldeRepository extends JpaRepository<AncienSolde, String>{
	/*@Query("SELECT a FROM AncienSolde a WHERE a.numero_compte = :numero_compte AND a.date_anc_solde = :date_anc_solde")
    AncienSolde findByIdAndDate(String id, LocalDate date);*/
}
