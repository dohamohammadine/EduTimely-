package com.example.projet_collectif.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Filiere {
    public String filiere;
    public int effectif;
    public List<Module> modules;

    @Override
    public String toString() {
        return filiere ;
    }
}

