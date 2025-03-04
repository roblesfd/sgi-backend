package com.fernandodev.sgi_backend.enums;

public enum PorcentajeDescuento {
    CINCO(5),
    DIEZ(10),
    QUINCE(15),
    VEINTE(20),
    VEINTICINCO(25),
    TREINTA(30),
    TREINTA_Y_CINCO(35),
    CUARENTA(40),
    CUARENTA_Y_CINCO(45),
    CINCUENTA(50);

    private final int porcentaje;

    PorcentajeDescuento(int porcentaje){
        this.porcentaje = porcentaje;
    }

    public int getPorcentaje(){
        return porcentaje;
    }
}
