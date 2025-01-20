package com.example.projet_collectif.controller;

import com.example.projet_collectif.model.Prof;
import com.example.projet_collectif.model.Salle;
import com.example.projet_collectif.service.ProfService;
import com.example.projet_collectif.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/salles")
public class SalleController {
    @Autowired
    private SalleService salleService;

    // Afficher la liste des salles
    @GetMapping
    public String listSalles(Model model) {
        model.addAttribute("salles", salleService.getAllSalles());
        return "list-salles";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/add")
    public String addSalleForm(Model model) {
        model.addAttribute("salle", new Salle());
        return "add-salle";
    }

    // Enregistrer une salle
    @PostMapping
    public String saveSalle(@ModelAttribute("salle") Salle salle) {
        salleService.saveSalle(salle);
        return "redirect:/salles";
    }

    // Supprimer une salle
    @GetMapping("/delete/{id}")
    public String deleteSalle(@PathVariable("id") Long id) {
        salleService.deleteSalle(id);
        return "redirect:/salles"; // Redirection après suppression
    }
}
