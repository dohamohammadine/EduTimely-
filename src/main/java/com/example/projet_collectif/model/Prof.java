package com.example.projet_collectif.model;

import jakarta.persistence.*;



@Entity
@Table(name = "profs")
public class Prof {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    public Prof() {
    }

    public Prof(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Prof{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
