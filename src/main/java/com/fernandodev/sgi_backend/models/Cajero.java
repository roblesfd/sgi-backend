package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.Rol;
import jakarta.persistence.Entity;

@Entity
public class Cajero extends Usuario {
    private String turno;
    private int cajaAsignada;

    //CONSTRUCTORES
    public Cajero(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String direccion, String turno, int cajaAsignada, Double salario) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, direccion, Rol.CAJERO, salario);
        this.turno = turno;
        this.cajaAsignada = cajaAsignada;
    }
    public Cajero() {
        super();
    }

    //GETTERS
    public String getTurno() {
        return turno;
    }
    public int getCajaAsignada() {
        return cajaAsignada;
    }

    //SETTERS
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public void setCajaAsignada(int cajaAsignada) {
        this.cajaAsignada = cajaAsignada;
    }
}
