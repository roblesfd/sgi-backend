package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Devolucion;
import com.fernandodev.sgi_backend.repositories.DevolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {
    @Autowired
    DevolucionRepository devolucionRepository;

    @GetMapping
    public List<Devolucion> listarDevoluciones(){
        return devolucionRepository.findAll();
    }

    @PostMapping
    public Devolucion agregarDevolucion(@RequestBody Devolucion devolucion) {
        return devolucionRepository.save(devolucion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devolucion> obtenerPorId(@PathVariable Long id){
        Optional<Devolucion> devolucion = devolucionRepository.findById(id);
        return devolucion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Devolucion> actualizarDevolucion(@PathVariable Long id, @RequestBody Devolucion devolucion) {
        if(!devolucionRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        devolucion.setId(id);
        Devolucion devolucionActualizado = devolucionRepository.save(devolucion);
        return ResponseEntity.ok(devolucionActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDevolucion(@PathVariable Long id){
        if(!devolucionRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        devolucionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
