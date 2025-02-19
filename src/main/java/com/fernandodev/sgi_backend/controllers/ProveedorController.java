package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Proveedor;
import com.fernandodev.sgi_backend.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    @Autowired
    ProveedorRepository proveedorRepository;

    @GetMapping
    public List<Proveedor> listarProveedores(){
        return proveedorRepository.findAll();
    }

    @PostMapping
    public Proveedor agregarProveedor(@RequestBody Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerPorId(@PathVariable Long id){
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        return proveedor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        if(!proveedorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        proveedor.setId(id);
        Proveedor proveedorActualizado = proveedorRepository.save(proveedor);
        return ResponseEntity.ok(proveedorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id){
        if(!proveedorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        proveedorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
