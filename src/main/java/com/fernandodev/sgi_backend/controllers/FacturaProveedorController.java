package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.FacturaProveedor;
import com.fernandodev.sgi_backend.repositories.FacturaProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturas-proveedores")
public class FacturaProveedorController {
    @Autowired
    FacturaProveedorRepository facturaProveedorRepository;

    @GetMapping
    public List<FacturaProveedor> listarFacturaProveedors(){
        return facturaProveedorRepository.findAll();
    }

    @PostMapping
    public FacturaProveedor agregarFacturaProveedor(@RequestBody FacturaProveedor facturaProveedor) {
        return facturaProveedorRepository.save(facturaProveedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaProveedor> obtenerPorId(@PathVariable Long id){
        Optional<FacturaProveedor> facturaProveedor = facturaProveedorRepository.findById(id);
        return facturaProveedor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaProveedor> actualizarFacturaProveedor(@PathVariable Long id, @RequestBody FacturaProveedor facturaProveedor) {
        if(!facturaProveedorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        facturaProveedor.setId(id);
        FacturaProveedor facturaProveedorActualizado = facturaProveedorRepository.save(facturaProveedor);
        return ResponseEntity.ok(facturaProveedorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFacturaProveedor(@PathVariable Long id){
        if(!facturaProveedorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        facturaProveedorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
