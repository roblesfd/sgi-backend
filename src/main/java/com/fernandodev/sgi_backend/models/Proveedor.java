package com.fernandodev.sgi_backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String contacto;
    private String direccion;
    private String email;
    @OneToMany(mappedBy="proveedor")
    private List<OrdenCompra> ordenesCompra;

    //CONSTRUCTORES
    public Proveedor(String name, String contact, String address, String email){
        this.nombre = name;
        this.contacto = contact;
        this.direccion = address;
        this.email = email;
    }

    public Proveedor(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getContacto() {
        return contacto;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getEmail() {
        return email;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
