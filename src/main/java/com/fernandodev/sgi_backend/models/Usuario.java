package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.regex.Pattern;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String nombre;

    @NotNull
    @Size(min = 3, max = 50)
    private String apellidoPaterno;

    @NotNull
    @Size(min = 3, max = 50)
    private String apellidoMaterno;

    @NotNull
    @Size(min = 10, max = 15)
    private String telefono;

    @NotNull
    @Size(max = 255)
    private String direccion;

    @NotNull
    @NotNull
    private Rol rol;

    @NotNull
    @Min(0)
    private double salario;

    @Email
    @NotNull
    private String correo;

    @NotNull
    @Size(min = 8, max = 50)
    private String contrasena;

    //CONSTRUCTORES
    protected Usuario(String name,
                      String firstSurname,
                      String lastSurname,
                      String phoneNumber,
                      String address,
                      Rol role,
                      Double salario,
                      String email,
                      String password
    ) {
        this.nombre = name;
        this.apellidoPaterno = firstSurname;
        this.apellidoMaterno = lastSurname;
        this.telefono = phoneNumber;
        this.direccion = address;
        this.rol = role;
        this.salario = salario;
        this.correo = email;
        this.contrasena = password;
    }

    protected Usuario(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public double getSalario() {
        return salario;
    }
    public String getCorreo() {
        return correo;
    }
    public String getContrasena() {
        return contrasena;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public Rol getRol() {
        return rol;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
