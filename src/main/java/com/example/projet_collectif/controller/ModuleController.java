
package com.example.projet_collectif.controller;

import com.example.projet_collectif.model.Module;
import com.example.projet_collectif.model.Prof;
import com.example.projet_collectif.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

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
        return "add-module";
    }

    // Enregistrer un nouveau module
    @PostMapping
    public String saveModule(@ModelAttribute Module module) {
        // Vérifier si un professeur est associé
        Prof prof = module.getProf();
        if (prof != null && prof.getNom() != null) {
            module.setProf(prof);
        }
        moduleService.saveModule(module);
        return "redirect:/modules";
    }

    // Supprimer un module
    @GetMapping("/delete/{id}")
    public String deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return "redirect:/modules";
    }
}
