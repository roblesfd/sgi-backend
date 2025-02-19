package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.MetodoPago;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaVenta;
    private Double total;
    private MetodoPago metodoPago;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;

    //CONSTRUCTORES
    public Venta(LocalDateTime saleDate, Double total, MetodoPago paymentMethod, List<DetalleVenta> details){
        this.fechaVenta = saleDate;
        this.total = total;
        this.metodoPago = paymentMethod;
        this.detalles = details;
    }

    public Venta(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }
    public Double getTotal() {
        return total;
    }
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
}
