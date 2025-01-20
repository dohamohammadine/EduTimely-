package com.example.projet_collectif.service;

import com.example.projet_collectif.model.Module;
import com.example.projet_collectif.model.Prof;
import com.example.projet_collectif.repository.ModuleRepository;
import com.example.projet_collectif.repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfService {
    @Autowired
    private ProfRepository profRepository;

    // Méthode pour récupérer tous les profs
    public List<Prof> getAllProfs() {
        return profRepository.findAll();
    }

    // Méthode pour récupérer un prof par ID
    public Optional<Prof> getProfById(int id) {
        return profRepository.findById(id);
    }

    // Méthode pour créer ou mettre à jour un prof
    public Prof saveProf(Prof prof) {
        return profRepository.save(prof);
    }

    // Méthode pour supprimer un prof
    public void deleteProf(int id) {
        profRepository.deleteById(id);
    }
}
