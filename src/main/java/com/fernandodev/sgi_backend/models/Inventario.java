package com.fernandodev.sgi_backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name="producto_id")
    private Producto producto;
    private Integer cantidadDisponible;
    private Integer stockMinimo;
    private String lote;
    private LocalDate fechaCaducidad;
    @OneToMany
    @JoinColumn(name="stock_id")
    private List<Stock> stocks;

    //CONSTRUCTORES
    public Inventario(Producto prod, Integer amountAvailable, Integer minStock, String batch, LocalDate expireDate, List<Stock> stock){
        this.producto = prod;
        this.cantidadDisponible = amountAvailable;
        this.stockMinimo = minStock;
        this.lote = batch;
        this.fechaCaducidad = expireDate;
        this.stocks = stock;
    }

    public Inventario(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public Producto getProducto() {
        return producto;
    }
    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }
    public Integer getStockMinimo() {
        return stockMinimo;
    }
    public String getLote() {
        return lote;
    }
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    public List<Stock> getStock() {
        return stocks;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    public void setStock(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
