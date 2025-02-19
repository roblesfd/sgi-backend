package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.EstadoDevolucion;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Devolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="producto_id")
    private Producto producto;
    private Integer cantidad;
    private String razonDevolucion;
    private LocalDate fechaDevolucion;
    @Enumerated(EnumType.STRING)
    private EstadoDevolucion estado;

    //CONSTRUCTORES
    public Devolucion(Producto producto, Integer cantidad, String razonDevolucion, EstadoDevolucion estado) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.razonDevolucion = razonDevolucion;
        this.estado = estado;
        this.fechaDevolucion = LocalDate.now(); // Fecha actual de la devolución
    }

    public Devolucion(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public Producto getProducto() {
        return producto;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public String getRazonDevolucion() {
        return razonDevolucion;
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public EstadoDevolucion getEstado() {
        return estado;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public void setRazonDevolucion(String razonDevolucion) {
        this.razonDevolucion = razonDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public void setEstado(EstadoDevolucion estado) {
        this.estado = estado;
    }
}
