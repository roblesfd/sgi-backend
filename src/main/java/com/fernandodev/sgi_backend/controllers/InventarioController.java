package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Inventario;
import com.fernandodev.sgi_backend.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {
    @Autowired
    InventarioRepository inventarioRepository;

    @GetMapping
    public List<Inventario> listarInventarios(){
        return inventarioRepository.findAll();
    }

    @PostMapping
    public Inventario agregarInventario(@RequestBody Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtenerPorId(@PathVariable Long id){
        Optional<Inventario> inventario = inventarioRepository.findById(id);
        return inventario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizarInventario(@PathVariable Long id, @RequestBody Inventario inventario) {
        if(!inventarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        inventario.setId(id);
        Inventario inventarioActualizado = inventarioRepository.save(inventario);
        return ResponseEntity.ok(inventarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable Long id){
        if(!inventarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        inventarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
