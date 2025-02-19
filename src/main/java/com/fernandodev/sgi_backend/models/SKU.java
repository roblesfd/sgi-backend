package com.fernandodev.sgi_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SKU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;

    //CONSTRUCTORS
    SKU(String code){
        this.codigo = code;
    }

    SKU(){}

    //GETTERS
    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
