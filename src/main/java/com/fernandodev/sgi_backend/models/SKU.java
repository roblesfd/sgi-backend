package com.fernandodev.sgi_backend.models;

import jakarta.persistence.*;

@Entity
public class SKU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String codigo;
    @OneToOne(mappedBy = "sku")
    private Producto producto;

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

    public Producto getProduct() {
        return producto;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setProduct(Producto product) {
        this.producto = product;
    }
}
