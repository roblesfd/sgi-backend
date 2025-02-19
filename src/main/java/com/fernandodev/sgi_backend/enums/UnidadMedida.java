package com.fernandodev.sgi_backend.enums;

public enum UnidadMedida {
    H87("Pieza"),
    KGM("Kilogramo"),
    GRM("Gramo"),
    LTR("Litro"),
    MTQ("Metro cúbico"),
    MTR("Metro"),
    CMQ("Centímetro cúbico"),
    CMT("Centímetro"),
    INH("Pulgada"),
    FOT("Pie"),
    HUR("Hora"),
    MIN("Minuto"),
    SEC("Segundo"),
    DAY("Día"),
    BLL("Barril"),
    GLL("Galón"),
    PR("Par"),
    C62("Unidad genérica");

    private final String nombre;

    UnidadMedida(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
