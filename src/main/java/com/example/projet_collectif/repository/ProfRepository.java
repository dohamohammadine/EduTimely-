package com.example.projet_collectif.repository;

import com.example.projet_collectif.model.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepository extends JpaRepository<Prof, Integer> {
}
