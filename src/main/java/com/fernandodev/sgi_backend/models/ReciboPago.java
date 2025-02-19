package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.MetodoPago;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ReciboPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaEmision;
    private BigDecimal total;
    private MetodoPago metodoPago;
    @OneToMany
    private List<Producto> productos;
    private String cliente;

    // CCONSTRUCTOR
    public ReciboPago(LocalDateTime fechaEmision, BigDecimal total, MetodoPago metodoPago, List<Producto> productos, String cliente) {
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.metodoPago = metodoPago;
        this.productos = productos;
        this.cliente = cliente;
    }

    public ReciboPago() {}

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public LocalDateTime getFechaEmision() { return fechaEmision; }
    public BigDecimal getTotal() { return total; }
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    //SETTERS
    public void setId (Long id){
        this.id = id;
    }
    public void setFechaEmision(LocalDateTime fechaEmision) { this.fechaEmision = fechaEmision; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public void setMetodoPago(MetodoPago metodoPago){
        this.metodoPago = metodoPago;
    }
}
