package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.Rol;
import jakarta.persistence.Entity;

@Entity
public class Gerente extends Usuario{
    private String sucursal;

    //CONSTRUCTORES
    public Gerente(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String direccion, String sucursal, Double salario) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, direccion, Rol.GERENTE, salario);
        this.sucursal = sucursal;
    }

    public Gerente(){
        super();
    }

    //GETTERS y SETTERS
    public String getSucursal() {
        return sucursal;
    }
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
}
