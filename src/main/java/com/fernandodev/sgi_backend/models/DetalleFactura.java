package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.UnidadMedida;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "factura_id", nullable = false)
    private FacturaProveedor facturaProveedor;
    private String descripcion;
    private UnidadMedida unidadMedida;
    private Integer cantidad;
    private BigDecimal valorUnitario;
    private BigDecimal importe;

    //CONSTRUCTORES
    public DetalleFactura(FacturaProveedor bill, String desc, UnidadMedida unit, Integer cant, BigDecimal unitVal, BigDecimal importe){
        this.facturaProveedor = bill;
        this.descripcion = desc;
        this.unidadMedida = unit;
        this.cantidad = cant;
        this.valorUnitario = unitVal;
        this.importe = importe;
    }

    public DetalleFactura(){}

    // GETTERS
    public Long getId() {
        return id;
    }
    public FacturaProveedor getFacturaProveedor() {
        return facturaProveedor;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
    public BigDecimal getImporte() {
        return importe;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setFacturaProveedor(FacturaProveedor facturaProveedor) {
        this.facturaProveedor = facturaProveedor;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        calcularImporte();
    }
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
        calcularImporte();
    }
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    // METODOS
    private void calcularImporte() {
        if (this.cantidad != null && this.valorUnitario != null) {
            this.importe = this.valorUnitario.multiply(BigDecimal.valueOf(this.cantidad));
        }
    }
}
