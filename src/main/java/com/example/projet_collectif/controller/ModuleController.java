package com.example.projet_collectif.controller;

import com.example.projet_collectif.model.Module;
import com.example.projet_collectif.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Endpoint pour récupérer tous les modules
    @GetMapping
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    // Endpoint pour récupérer un module par ID
    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Optional<Module> module = moduleService.getModuleById(id);
        return module.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint pour créer ou mettre à jour un module
    @PostMapping
    public Module createOrUpdateModule(@RequestBody Module module) {
        return moduleService.saveModule(module);
    }

    // Endpoint pour supprimer un module
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}
