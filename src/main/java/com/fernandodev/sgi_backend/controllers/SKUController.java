package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.SKU;
import com.fernandodev.sgi_backend.repositories.SKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skus")
public class SKUController {
    @Autowired
    SKURepository skuRepository;

    @GetMapping
    public List<SKU> listarSKUs(){
        return skuRepository.findAll();
    }

    @PostMapping
    public SKU agregarSKU(@RequestBody SKU sku) {
        return skuRepository.save(sku);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SKU> obtenerPorId(@PathVariable Long id){
        Optional<SKU> sku = skuRepository.findById(id);
        return sku.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SKU> actualizarSKU(@PathVariable Long id, @RequestBody SKU sku) {
        if(!skuRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        sku.setId(id);
        SKU skuActualizado = skuRepository.save(sku);
        return ResponseEntity.ok(skuActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSKU(@PathVariable Long id){
        if(!skuRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        skuRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
