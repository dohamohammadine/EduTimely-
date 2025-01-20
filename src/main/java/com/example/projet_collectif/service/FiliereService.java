package com.example.projet_collectif.service;

import com.example.projet_collectif.model.Filiere;
import com.example.projet_collectif.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    // Méthode pour récupérer toutes les filières
    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    // Méthode pour récupérer une filière par ID
    public Optional<Filiere> getFiliereById(Long id) {
        return filiereRepository.findById(id);
    }

    // Méthode pour créer ou mettre à jour une filière
    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    // Méthode pour supprimer une filière
    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }
}
