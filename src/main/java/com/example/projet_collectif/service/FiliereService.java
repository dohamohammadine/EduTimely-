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

    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    public Optional<Filiere> getFiliereById(Long id) {
        return filiereRepository.findById(id);
    }

    public Filiere saveFiliere(Filiere filiere) {
        // Vérifiez si une filière avec le même nom (insensible à la casse) existe déjà
        List<Filiere> existingFilieres = filiereRepository.findByNomIgnoreCase(filiere.getNom());
        if (!existingFilieres.isEmpty()) {
            throw new IllegalArgumentException("Une filière avec ce nom existe déjà : " + filiere.getNom());
        }

        return filiereRepository.save(filiere);
    }

    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }
}
