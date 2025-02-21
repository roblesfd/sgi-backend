package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Lote;
import com.fernandodev.sgi_backend.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lotes")
public class LoteController {
    @Autowired
    LoteRepository loteRepository;

    @GetMapping
    public List<Lote> listarLotes(){
        return loteRepository.findAll();
    }

    @PostMapping
    public Lote agregarLote(@RequestBody Lote lote) {
        return loteRepository.save(lote);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> obtenerPorId(@PathVariable Long id){
        Optional<Lote> lote = loteRepository.findById(id);
        return lote.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> actualizarLote(@PathVariable Long id, @RequestBody Lote lote) {
        if(!loteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        lote.setId(id);
        Lote loteActualizado = loteRepository.save(lote);
        return ResponseEntity.ok(loteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLote(@PathVariable Long id){
        if(!loteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        loteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
