package com.example.projet_collectif.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Prof {
    public int id;
    public String nom;

    @Override
    public String toString() {
        return "{id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
