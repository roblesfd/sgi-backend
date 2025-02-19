package com.fernandodev.sgi_backend.models;


import com.fernandodev.sgi_backend.enums.TipoOferta;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private TipoOferta tipo;
    private BigDecimal descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    //CONSTRUCTORES
    public Oferta(String name, String desc, TipoOferta type, BigDecimal discount, LocalDate startDate, LocalDate endDate){
        this.nombre = name;
        this.descripcion = desc;
        this.tipo = type;
        this.descuento = discount;
        this.fechaInicio = startDate;
        this.fechaFin = endDate;
    }

    public Oferta(){}

    // GETTERS
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public TipoOferta getTipo() {
        return tipo;
    }
    public BigDecimal getDescuento() {
        return descuento;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public Producto getProducto() {
        return producto;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setTipo(TipoOferta tipo) {
        this.tipo = tipo;
    }
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
