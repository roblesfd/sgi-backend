package com.fernandodev.sgi_backend.models;

import jakarta.persistence.*;

@Entity
public class DetalleOrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private OrdenCompra ordenCompra;
    @ManyToOne
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;

    //CONSTRUCTORES
    public DetalleOrdenCompra(OrdenCompra order, Producto prod, Integer cant, Double price){
        this.ordenCompra = order;
        this.producto = prod;
        this.cantidad = cant;
        this.precioUnitario = price;
    }

    public DetalleOrdenCompra(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
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
    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
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
