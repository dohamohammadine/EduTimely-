package com.example.projet_collectif.repository;


import com.example.projet_collectif.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    @Query("SELECT f FROM Filiere f WHERE LOWER(f.nom) = LOWER(:nom)")
    List<Filiere> findByNomIgnoreCase(@Param("nom") String nom);
}
