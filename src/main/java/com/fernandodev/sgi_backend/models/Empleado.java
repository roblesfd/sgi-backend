package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.Rol;
import jakarta.persistence.Entity;

@Entity
public class Empleado extends Usuario {
    private String departamento;

    //CONSTRUCTORES
    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String direccion, String departamento, Double salario) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, direccion, Rol.EMPLEADO_ALMACEN, salario);
        this.departamento = departamento;
    }

    public Empleado() {
        super();
    }

    //GETTERS
    public String getDepartamento() {
        return departamento;
    }

    //SETTERS
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
