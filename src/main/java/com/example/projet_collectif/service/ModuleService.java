package com.example.projet_collectif.service;

import com.example.projet_collectif.model.Module;
import com.example.projet_collectif.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    // Récupérer tous les modules
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    // Récupérer un module par ID
    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    // Créer ou mettre à jour un module
    public Module saveModule(Module module) {
        return moduleRepository.save(module);
    }

    // Supprimer un module
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
