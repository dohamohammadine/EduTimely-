package com.example.projet_collectif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filieres")
public class Filiere {

    @Id
    private Long id; // Un identifiant pour la filière

    private String filiere;

    private int effectif;

    @OneToMany(mappedBy = "filiere") // Relation avec les modules
    private List<Module> modules;

    @Override
    public String toString() {
        return "Filiere{" +
                "filiere='" + filiere + '\'' +
                ", effectif=" + effectif +
                ", modules=" + modules +
                '}';
    }
}
