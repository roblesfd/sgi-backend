package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Cajero;
import com.fernandodev.sgi_backend.repositories.CajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cajeros")
public class CajeroController {
    @Autowired
    CajeroRepository cajeroRepository;

    @GetMapping
    public List<Cajero> listarCajeros(){
        return cajeroRepository.findAll();
    }

    @PostMapping
    public Cajero agregarCajero(@RequestBody Cajero cajero) {
        return cajeroRepository.save(cajero);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cajero> obtenerPorId(@PathVariable Long id){
        Optional<Cajero> cajero = cajeroRepository.findById(id);
        return cajero.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cajero> actualizarCajero(@PathVariable Long id, @RequestBody Cajero cajero) {
        if(!cajeroRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        cajero.setId(id);
        Cajero cajeroActualizado = cajeroRepository.save(cajero);
        return ResponseEntity.ok(cajeroActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCajero(@PathVariable Long id){
        if(!cajeroRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        cajeroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
