package com.example.projet_collectif.controller;

import com.example.projet_collectif.model.Filiere;
import com.example.projet_collectif.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    // Afficher la liste des filières
    @GetMapping
    public String listFilieres(Model model) {
        model.addAttribute("filieres", filiereService.getAllFilieres());
        return "list-filieres";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/add")
    public String addFiliereForm(Model model) {
        model.addAttribute("filiere", new Filiere());
        return "add-filiere";
    }

    // Enregistrer une nouvelle filière
//    @PostMapping
//    public String saveFiliere(@ModelAttribute("filiere") Filiere filiere) {
//        // Initialiser la liste des modules à vide et sauvegarder la filière
//        filiere.setModules(Collections.emptyList());
//        filiereService.saveFiliere(filiere);
//        return "redirect:/filieres";
//    }
    @PostMapping
    public String saveFiliere(@ModelAttribute("filiere") Filiere filiere, Model model) {
        try {
            filiere.setModules(Collections.emptyList());
            filiereService.saveFiliere(filiere);
            return "redirect:/filieres";
        } catch (IllegalArgumentException e) {
        model.addAttribute("errorMessage", e.getMessage());
        return "add-filiere";
    } catch (DataIntegrityViolationException e) {
        model.addAttribute("errorMessage", "Une filière avec ce nom existe déjà (insensible à la casse).");
        return "add-filiere";
    }
    }

    // Supprimer une filière
    @GetMapping("/delete/{id}")
    public String deleteFiliere(@PathVariable("id") Long id) {
        filiereService.deleteFiliere(id);
        return "redirect:/filieres";
    }
}
