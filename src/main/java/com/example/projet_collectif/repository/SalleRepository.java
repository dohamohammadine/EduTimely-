package com.example.projet_collectif.repository;

import com.example.projet_collectif.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
}
