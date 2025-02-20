package com.fernandodev.sgi_backend.models;

import jakarta.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String codigoBarras;
    private String descripcion;
    private Double precio;
    private Double peso;
    @ManyToOne
    private Categoria categoria;
    @OneToOne(mappedBy = "producto", cascade=CascadeType.ALL)
    private Inventario inventario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sku_id", unique = true) // Asegura unicidad
    private SKU sku;

    //CONSTRUCTORES
    public Producto(String name, String barCode, String desc, Double price, Double weight, Categoria category, Inventario inventory){
        this.nombre = name;
        this.codigoBarras = barCode;
        this.descripcion = desc;
        this.precio = price;
        this.peso = weight;
        this.categoria = category;
        this.inventario = inventory;
    }

    public Producto(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCodigoBarras() {
        return codigoBarras;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Double getPrecio() {
        return precio;
    }
    public Double getPeso() {
        return peso;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public Inventario getInventario() {
        return inventario;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}
