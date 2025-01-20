package com.example.projet_collectif.controller;

import com.example.projet_collectif.model.Filiere;
import com.example.projet_collectif.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    // Afficher la liste des filières
    @GetMapping
    public String listFilieres(Model model) {
        model.addAttribute("filieres", filiereService.getAllFilieres());
        return "list-filieres"; // Correspond exactement au fichier list-filieres.html
    }
    @GetMapping("/test")
    public String testPage() {
        return "test"; // Correspond au fichier test.html
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/add")
    public String addFiliereForm(Model model) {
        model.addAttribute("filiere", new Filiere()); // Crée un nouvel objet Filiere pour le formulaire
        return "add_filiere"; // Correspond au nom du fichier add_filiere.html
    }



    // Enregistrer une nouvelle filière
    @PostMapping
    public String saveFiliere(@ModelAttribute("filiere") Filiere filiere) {
        filiereService.saveFiliere(filiere);
        return "redirect:/filieres"; // Redirection vers la liste des filières
    }

//    // Supprimer une filière
//    @GetMapping("/delete/{id}")
//    public String deleteFiliere(@PathVariable("id") Long id) {
//        filiereService.deleteFiliere(id);
//        return "redirect:/filieres"; // Redirection après suppression
//    }
}
