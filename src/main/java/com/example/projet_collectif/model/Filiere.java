package com.example.projet_collectif.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "filieres")
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour la filière

    private String nom; // Nom de la filière

    private int effectif; // Effectif d'étudiants dans la filière

    @OneToMany(mappedBy = "filiere") // Relation avec les modules
    private List<Module> modules;

    public Filiere() {
    }

    // Constructeur avec tous les paramètres
    public Filiere(Long id, String nom, int effectif, List<Module> modules) {
        this.id = id;
        this.nom = nom;
        this.effectif = effectif;
        this.modules = modules;
    }

    // Constructeur sans la liste des modules
    public Filiere(Long id, String nom, int effectif) {
        this.id = id;
        this.nom = nom;
        this.effectif = effectif;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", effectif=" + effectif +
                ", modules=" + modules +
                '}';
    }
}
