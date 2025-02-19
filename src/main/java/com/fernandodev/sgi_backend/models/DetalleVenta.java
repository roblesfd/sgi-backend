package com.fernandodev.sgi_backend.models;

import jakarta.persistence.*;

@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Venta venta;
    @ManyToOne
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;

    //CONSTRUCTORES
    public DetalleVenta(Venta sale, Producto prod, Integer cant, Double price){
        this.venta = sale;
        this.producto = prod;
        this.cantidad = cant;
        this.precioUnitario = price;
    }

    public DetalleVenta(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public Venta getVenta() {
        return venta;
    }
    public Producto getProducto() {
        return producto;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
