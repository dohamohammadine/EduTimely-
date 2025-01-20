package com.example.projet_collectif.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "salles")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private int capacite;
    private Boolean prise = false;

    public Salle() {
    }

    public Salle(Long id, String numero, int capacite, Boolean prise) {
        this.id = id;
        this.numero = numero;
        this.capacite = capacite;
        this.prise = prise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Boolean getPrise() {
        return prise;
    }

    public void setPrise(Boolean prise) {
        this.prise = prise;
    }
}
