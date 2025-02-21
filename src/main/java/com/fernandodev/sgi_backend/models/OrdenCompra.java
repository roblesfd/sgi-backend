package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.EstadoOrden;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="proveedor_id")
    private Proveedor proveedor;
    @OneToMany(mappedBy="ordenCompra", cascade=CascadeType.ALL)
    private List<DetalleOrdenCompra> detalles;
    private LocalDate fechaOrden;
    private LocalDate fechaEntregaEstimada;
    @Enumerated(EnumType.STRING)
    private EstadoOrden estado;
    private Double total;


    //CONSTRUCTORES
    public OrdenCompra(Proveedor provider, List<DetalleOrdenCompra> details, LocalDate orderDate, LocalDate estimatedDeliveryDate, EstadoOrden state, Double total){
        this.proveedor = provider;
        this.detalles = details;
        this.fechaOrden = orderDate;
        this.fechaEntregaEstimada = estimatedDeliveryDate;
        this.estado = state;
        this.total = total;
    }

    public OrdenCompra(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    public List<DetalleOrdenCompra> getDetalles() {
        return detalles;
    }
    public LocalDate getFechaOrden() {
        return fechaOrden;
    }
    public LocalDate getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }
    public EstadoOrden getEstado() {
        return estado;
    }
    public Double getTotal() {
        return total;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public void setDetalles(List<DetalleOrdenCompra> detalles) {
        this.detalles = detalles;
    }
    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }
    public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
    }
    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
}
