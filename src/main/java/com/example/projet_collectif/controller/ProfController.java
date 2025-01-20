package com.example.projet_collectif.controller;

import com.example.projet_collectif.model.Prof;
import com.example.projet_collectif.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profs")
public class ProfController {
    @Autowired
    private ProfService profService;

    // Afficher la liste des profs
    @GetMapping
    public String listProfs(Model model) {
        model.addAttribute("profs", profService.getAllProfs());
        return "list-profs";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/add")
    public String addProfForm(Model model) {
        model.addAttribute("prof", new Prof());
        return "add-prof";
    }

    // Enregistrer un prof
    @PostMapping
    public String saveProf(@ModelAttribute("prof") Prof prof) {
        profService.saveProf(prof);
        return "redirect:/profs";
    }

    // Supprimer une filière
    @GetMapping("/delete/{id}")
    public String deleteProf(@PathVariable("id") int id) {
        profService.deleteProf(id);
        return "redirect:/profs"; // Redirection après suppression
    }
}
