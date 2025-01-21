package com.example.projet_collectif.controller;

import com.example.projet_collectif.model.Filiere;
import com.example.projet_collectif.model.Module;
import com.example.projet_collectif.model.Prof;
import com.example.projet_collectif.service.FiliereService;
import com.example.projet_collectif.service.ModuleService;
import com.example.projet_collectif.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private FiliereService filiereService;

    @Autowired
    private ProfService profService;

    // Afficher la liste des modules
    @GetMapping
    public String listModules(Model model) {
        model.addAttribute("modules", moduleService.getAllModules());
        return "list-modules";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/add")
    public String addModuleForm(Model model) {
        model.addAttribute("module", new Module());
        model.addAttribute("filieres", filiereService.getAllFilieres());
        model.addAttribute("profs", profService.getAllProfs());
        return "add-module";
    }

    // Enregistrer un module
    @PostMapping
    public String saveModule(@ModelAttribute("module") Module module) {
        // Récupérer l'instance persistée de Filiere à partir de son ID
        Filiere filiere = filiereService.getFiliereById(module.getFiliere().getId())
                .orElseThrow(() -> new IllegalArgumentException("Filiere non trouvée"));

        // Récupérer l'instance persistée de Prof à partir de son ID
        Prof prof = profService.getProfById(module.getProf().getId())
                .orElseThrow(() -> new IllegalArgumentException("Professeur non trouvé"));

        // Associer les entités persistées au module
        module.setFiliere(filiere);
        module.setProf(prof);

        // Initialisation de l'état par défaut
        module.setPrise(module.getPrise());

        // Sauvegarder le module
        moduleService.saveModule(module);

        return "redirect:/modules";
    }


    // Supprimer un module
    @GetMapping("/delete/{id}")
    public String deleteModule(@PathVariable("id") Long id) {
        moduleService.deleteModule(id);
        return "redirect:/modules";
    }
}
