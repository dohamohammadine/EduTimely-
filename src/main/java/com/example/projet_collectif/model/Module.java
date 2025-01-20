package com.example.projet_collectif.model;

import lombok.Getter;

@Getter
public class Module {
    public String module;
    public Prof prof;
    public Boolean prise = false;
    public Module(String module, Prof prof) {
        this.module = module;
        this.prof = prof;
    }

    public Module(String module, Prof prof, Boolean prise) {
        this.module = module;
        this.prof = prof;
        this.prise = prise;
    }


    @Override
    public String toString() {
        return "Module{" +
                "module='" + module + '\'' +
                ", prof=" + prof +
                ", prise=" + prise +
                '}';
    }
}
