package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Gerente;
import com.fernandodev.sgi_backend.repositories.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {
    @Autowired
    GerenteRepository gerenteRepository;

    @GetMapping
    public List<Gerente> listarGerentes(){
        return gerenteRepository.findAll();
    }

    @PostMapping
    public Gerente agregarGerente(@RequestBody Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> obtenerPorId(@PathVariable Long id){
        Optional<Gerente> gerente = gerenteRepository.findById(id);
        return gerente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gerente> actualizarGerente(@PathVariable Long id, @RequestBody Gerente gerente) {
        if(!gerenteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        gerente.setId(id);
        Gerente gerenteActualizado = gerenteRepository.save(gerente);
        return ResponseEntity.ok(gerenteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGerente(@PathVariable Long id){
        if(!gerenteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        gerenteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
