package com.example.projet_collectif.controller;

import com.example.projet_collectif.model.Filiere;
import com.example.projet_collectif.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    // Endpoint pour récupérer toutes les filières
    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    // Endpoint pour récupérer une filière par ID
    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getFiliereById(@PathVariable Long id) {
        Optional<Filiere> filiere = filiereService.getFiliereById(id);
        return filiere.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint pour créer ou mettre à jour une filière
    @PostMapping
    public Filiere createOrUpdateFiliere(@RequestBody Filiere filiere) {
        return filiereService.saveFiliere(filiere);
    }

    // Endpoint pour supprimer une filière
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return ResponseEntity.noContent().build();
    }
}
