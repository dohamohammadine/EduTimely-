package com.example.projet_collectif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "modules")
public class Module {

    @Id
    private Long id;

    private String module;

    @ManyToOne
    private Prof prof;

    private Boolean prise = false;

    @ManyToOne // Relation avec Filiere
    private Filiere filiere;

    public Module(String module, Prof prof, Filiere filiere) {
        this.module = module;
        this.prof = prof;
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Module{" +
                "module='" + module + '\'' +
                ", prof=" + prof +
                ", prise=" + prise +
                ", filiere=" + filiere +
                '}';
    }
}
