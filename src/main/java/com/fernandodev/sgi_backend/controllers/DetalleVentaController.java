package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.DetalleVenta;
import com.fernandodev.sgi_backend.repositories.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-ventas")
public class DetalleVentaController {
    @Autowired
    DetalleVentaRepository detalleVentaRepository;

    @GetMapping
    public List<DetalleVenta> listarDetalleVentas(){
        return detalleVentaRepository.findAll();
    }

    @PostMapping
    public DetalleVenta agregarDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> obtenerPorId(@PathVariable Long id){
        Optional<DetalleVenta> detalleVenta = detalleVentaRepository.findById(id);
        return detalleVenta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> actualizarDetalleVenta(@PathVariable Long id, @RequestBody DetalleVenta detalleVenta) {
        if(!detalleVentaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        detalleVenta.setId(id);
        DetalleVenta detalleVentaActualizado = detalleVentaRepository.save(detalleVenta);
        return ResponseEntity.ok(detalleVentaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleVenta(@PathVariable Long id){
        if(!detalleVentaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        detalleVentaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
