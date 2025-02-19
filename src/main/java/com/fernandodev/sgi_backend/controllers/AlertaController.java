package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Alerta;
import com.fernandodev.sgi_backend.repositories.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alertas")
public class AlertaController {
    @Autowired
    AlertaRepository alertaRepository;

    @GetMapping
    public List<Alerta> listarAlertas(){
        return alertaRepository.findAll();
    }

    @PostMapping
    public Alerta agregarAlerta(@RequestBody Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> obtenerPorId(@PathVariable Long id){
        Optional<Alerta> alerta = alertaRepository.findById(id);
        return alerta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> actualizarAlerta(@PathVariable Long id, @RequestBody Alerta alerta) {
        if(!alertaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        alerta.setId(id);
        Alerta alertaActualizado = alertaRepository.save(alerta);
        return ResponseEntity.ok(alertaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlerta(@PathVariable Long id){
        if(!alertaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        alertaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
