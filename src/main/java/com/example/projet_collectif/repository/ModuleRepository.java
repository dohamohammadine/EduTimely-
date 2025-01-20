package com.example.projet_collectif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projet_collectif.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
