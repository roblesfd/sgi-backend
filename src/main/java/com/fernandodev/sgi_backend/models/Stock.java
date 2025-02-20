package com.fernandodev.sgi_backend.models;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "producto_id", nullable = false, unique = true)
    private Producto producto;
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "inventario_id", nullable = false)
    private Inventario inventario;
    private int stockMinimo;
    private int stockMaximo;

    // CONSTRUCTORES
    public Stock() {}

    public Stock(Producto producto, int cantidad, Inventario inventario, int stockMinimo, int stockMaximo) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.inventario = inventario;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

