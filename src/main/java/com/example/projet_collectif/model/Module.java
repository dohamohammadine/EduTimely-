package com.example.projet_collectif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public Module(Long id, String module, Prof prof, Boolean prise, Filiere filiere) {
        this.id = id;
        this.module = module;
        this.prof = prof;
        this.prise = prise;
        this.filiere = filiere;
    }

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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
                "module='" + module + '\'' +
                ", prof=" + prof +
                ", prise=" + prise +
                ", filiere=" + filiere +
                '}';
    }
}
