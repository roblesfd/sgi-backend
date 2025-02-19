package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Oferta;
import com.fernandodev.sgi_backend.repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {
    @Autowired
    OfertaRepository ofertaRepository;

    @GetMapping
    public List<Oferta> listarOfertas(){
        return ofertaRepository.findAll();
    }

    @PostMapping
    public Oferta agregarOferta(@RequestBody Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oferta> obtenerPorId(@PathVariable Long id){
        Optional<Oferta> oferta = ofertaRepository.findById(id);
        return oferta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oferta> actualizarOferta(@PathVariable Long id, @RequestBody Oferta oferta) {
        if(!ofertaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        oferta.setId(id);
        Oferta ofertaActualizado = ofertaRepository.save(oferta);
        return ResponseEntity.ok(ofertaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOferta(@PathVariable Long id){
        if(!ofertaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        ofertaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
