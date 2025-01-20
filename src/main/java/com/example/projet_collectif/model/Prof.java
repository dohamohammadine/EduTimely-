package com.example.projet_collectif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profs")
public class Prof {

    @Id // Clé primaire
    private int id;

    private String nom;

    @Override
    public String toString() {
        return "Prof{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
