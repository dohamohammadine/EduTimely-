package com.example.projet_collectif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "profs")
public class Prof {

    @Id // Clé primaire
    private int id;

    private String nom;

    public Prof() {
    }

    public Prof(int id, String nom) {
        this.id = id;
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
