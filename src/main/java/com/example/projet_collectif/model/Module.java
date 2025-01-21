package com.example.projet_collectif.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique du module

    private String nom; // Nom du module

    @ManyToOne
    @JoinColumn(name = "prof_id") // Clé étrangère vers Prof
    private Prof prof; // Le professeur associé au module

    private Boolean prise = false; // Indique si le module est pris

    @ManyToOne
    @JoinColumn(name = "filiere_id") // Clé étrangère vers Filiere
    private Filiere filiere; // La filière associée au module

    // Constructeurs
    public Module() {
    }

    public Module(String nom, Prof prof, Filiere filiere) {
        this.nom = nom;
        this.prof = prof;
        this.filiere = filiere;
    }

    public Module(Long id, String nom, Prof prof, Boolean prise, Filiere filiere) {
        this.id = id;
        this.nom = nom;
        this.prof = prof;
        this.prise = prise;
        this.filiere = filiere;
    }

    public Module(Long id, String nom) {
        this.id = id;
        this.nom = nom;

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

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Boolean getPrise() {
        return prise;
    }

    public void setPrise(Boolean prise) {
        this.prise = prise;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prof=" + prof +
                ", prise=" + prise +
                ", filiere=" + filiere +
                '}';
    }
}
