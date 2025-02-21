package com.fernandodev.sgi_backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Lote {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String numeroLote;
    private int cantidad;
    private LocalDate fechaVencimiento;
    @ManyToOne
    @JoinColumn(name="producto_id", nullable=false)
    private Producto producto;

    //CONSTRUCTORES
    public Lote(String numeroLote, int cantidad, LocalDate fechaVencimiento, Producto producto){
        this.numeroLote = numeroLote;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
        this.producto = producto;
    }

    public Lote(){}

    //GETTERS
    public Long getId() {
        return id;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
