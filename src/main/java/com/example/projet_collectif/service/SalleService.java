package com.example.projet_collectif.service;

import com.example.projet_collectif.model.Prof;
import com.example.projet_collectif.model.Salle;
import com.example.projet_collectif.repository.ProfRepository;
import com.example.projet_collectif.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    // Méthode pour récupérer tous les salles
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    // Méthode pour récupérer une salle par ID
    public Optional<Salle> getSalleById(Long id) {
        return salleRepository.findById(id);
    }

    // Méthode pour créer ou mettre à jour une salle
    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    // Méthode pour supprimer une salle
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }
}
