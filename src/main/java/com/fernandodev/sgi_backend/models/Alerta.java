package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.TipoAlerta;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Alerta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String contenido;
    private TipoAlerta tipo;
    private LocalDateTime fecha;

    //CONSTRUCTORES
    public Alerta(String title, String content, TipoAlerta type, LocalDateTime date){
        this.titulo = title;
        this.contenido = content;
        this.tipo = type;
        this.fecha = date;
    }

    public Alerta(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public TipoAlerta getTipo() {
        return tipo;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public void setTipo(TipoAlerta tipo) {
        this.tipo = tipo;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
