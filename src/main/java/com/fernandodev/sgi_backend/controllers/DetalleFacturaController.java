package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.DetalleFactura;
import com.fernandodev.sgi_backend.repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-facturas")
public class DetalleFacturaController {
    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @GetMapping
    public List<DetalleFactura> listarDetalleFacturas(){
        return detalleFacturaRepository.findAll();
    }

    @PostMapping
    public DetalleFactura agregarDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> obtenerPorId(@PathVariable Long id){
        Optional<DetalleFactura> detalleFactura = detalleFacturaRepository.findById(id);
        return detalleFactura.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleFactura> actualizarDetalleFactura(@PathVariable Long id, @RequestBody DetalleFactura detalleFactura) {
        if(!detalleFacturaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        detalleFactura.setId(id);
        DetalleFactura detalleFacturaActualizado = detalleFacturaRepository.save(detalleFactura);
        return ResponseEntity.ok(detalleFacturaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleFactura(@PathVariable Long id){
        if(!detalleFacturaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        detalleFacturaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
