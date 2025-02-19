package com.fernandodev.sgi_backend.models;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int totalVentas;
    private BigDecimal ingresosTotales;
    private BigDecimal gananciaNeta;

    // CONSTRUCTORES
    public Reporte(LocalDate fechaInicio, LocalDate fechaFin, int totalVentas, BigDecimal ingresosTotales, BigDecimal gananciaNeta) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalVentas = totalVentas;
        this.ingresosTotales = ingresosTotales;
        this.gananciaNeta = gananciaNeta;
    }

    public Reporte() {}

    // GETTERS
    public Long getId() { return id; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public int getTotalVentas() { return totalVentas; }
    public BigDecimal getIngresosTotales() { return ingresosTotales; }
    public BigDecimal getGananciaNeta() { return gananciaNeta; }

    //SETTERS
    public void setId(Long id) { this.id = id; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public void setTotalVentas(int totalVentas) { this.totalVentas = totalVentas; }
    public void setIngresosTotales(BigDecimal ingresosTotales) { this.ingresosTotales = ingresosTotales; }
    public void setGananciaNeta(BigDecimal gananciaNeta) { this.gananciaNeta = gananciaNeta; }



}
