package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.MetodoPago;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class FacturaProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;
    private String rfc; // Registro Federal de Contribuyentes del receptor
    private String regimenFiscal;
    private String usoFiscal;
    private String codigoPostal;
    @OneToMany(mappedBy = "facturaProveedor", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalles;
    private BigDecimal total;
    private MetodoPago formaPago;
    private boolean pagoEnUnaExhibicion;
    private BigDecimal impuestosTrasladados;
    private BigDecimal impuestosRetenidos;
    private LocalDate fechaEmision;

    //CONSTRUCTOR
    public FacturaProveedor(
            Proveedor proveedor, String rfc, String regimenFiscal, String usoFiscal, String codigoPostal,
            List<DetalleFactura> detalles, BigDecimal total, MetodoPago formaPago, boolean pagoEnUnaExhibicion,
            BigDecimal impuestosTrasladados, BigDecimal impuestosRetenidos, LocalDate fechaEmision) {

        this.proveedor = proveedor;
        this.rfc = rfc;
        this.regimenFiscal = regimenFiscal;
        this.usoFiscal = usoFiscal;
        this.codigoPostal = codigoPostal;
        this.detalles = detalles;
        this.total = total;
        this.formaPago = formaPago;
        this.pagoEnUnaExhibicion = pagoEnUnaExhibicion;
        this.impuestosTrasladados = impuestosTrasladados;
        this.impuestosRetenidos = impuestosRetenidos;
        this.fechaEmision = fechaEmision;
    }

    public FacturaProveedor(){}


    // GETTERS
    public Long getId() {
        return id;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    public String getRfc() {
        return rfc;
    }
    public String getRegimenFiscal() {
        return regimenFiscal;
    }
    public String getUsoFiscal() {
        return usoFiscal;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public List<DetalleFactura> getDetalles() {
        return detalles;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public MetodoPago getFormaPago() {
        return formaPago;
    }
    public boolean isPagoEnUnaExhibicion() {
        return pagoEnUnaExhibicion;
    }
    public BigDecimal getImpuestosTrasladados() {
        return impuestosTrasladados;
    }
    public BigDecimal getImpuestosRetenidos() {
        return impuestosRetenidos;
    }
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }
    public void setUsoFiscal(String usoFiscal) {
        this.usoFiscal = usoFiscal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public void setFormaPago(MetodoPago formaPago) {
        this.formaPago = formaPago;
    }
    public void setPagoEnUnaExhibicion(boolean pagoEnUnaExhibicion) {
        this.pagoEnUnaExhibicion = pagoEnUnaExhibicion;
    }
    public void setImpuestosTrasladados(BigDecimal impuestosTrasladados) {
        this.impuestosTrasladados = impuestosTrasladados;
    }
    public void setImpuestosRetenidos(BigDecimal impuestosRetenidos) {
        this.impuestosRetenidos = impuestosRetenidos;
    }
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
