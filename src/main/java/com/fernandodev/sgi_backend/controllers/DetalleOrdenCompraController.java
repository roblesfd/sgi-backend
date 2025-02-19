package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.DetalleOrdenCompra;
import com.fernandodev.sgi_backend.repositories.DetalleOrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-ordenes-compra")
public class DetalleOrdenCompraController {
    @Autowired
    DetalleOrdenCompraRepository detalleOrdenCompraRepository;

    @GetMapping
    public List<DetalleOrdenCompra> listarDetalleOrdenCompras(){
        return detalleOrdenCompraRepository.findAll();
    }

    @PostMapping
    public DetalleOrdenCompra agregarDetalleOrdenCompra(@RequestBody DetalleOrdenCompra detalleOrdenCompra) {
        return detalleOrdenCompraRepository.save(detalleOrdenCompra);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrdenCompra> obtenerPorId(@PathVariable Long id){
        Optional<DetalleOrdenCompra> detalleOrdenCompra = detalleOrdenCompraRepository.findById(id);
        return detalleOrdenCompra.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleOrdenCompra> actualizarDetalleOrdenCompra(@PathVariable Long id, @RequestBody DetalleOrdenCompra detalleOrdenCompra) {
        if(!detalleOrdenCompraRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        detalleOrdenCompra.setId(id);
        DetalleOrdenCompra detalleOrdenCompraActualizado = detalleOrdenCompraRepository.save(detalleOrdenCompra);
        return ResponseEntity.ok(detalleOrdenCompraActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleOrdenCompra(@PathVariable Long id){
        if(!detalleOrdenCompraRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        detalleOrdenCompraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
