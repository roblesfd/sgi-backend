package com.fernandodev.sgi_backend.enums;

public enum TipoPromocion {
    COMPRA_UNO_LLEVA_OTRO("Compra uno y llévate otro gratis"),
    COMPRA_MAS_BAJA_PRECIO("Compra más y paga menos"),
    REGALO_POR_COMPRA("Regalo por compra"),
    PUNTOS_RECOMPENSA("Acumulación de puntos"),
    HORA_FELIZ("Descuentos por tiempo limitado");


    private final String descripcion;

    TipoPromocion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}