package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.OrdenCompra;
import com.fernandodev.sgi_backend.repositories.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordenes-compra")
public class OrdenCompraController {
    @Autowired
    OrdenCompraRepository ordenCompraRepository;

    @GetMapping
    public List<OrdenCompra> listarOrdenCompras(){
        return ordenCompraRepository.findAll();
    }

    @PostMapping
    public OrdenCompra agregarOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> obtenerPorId(@PathVariable Long id){
        Optional<OrdenCompra> ordenCompra = ordenCompraRepository.findById(id);
        return ordenCompra.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompra> actualizarOrdenCompra(@PathVariable Long id, @RequestBody OrdenCompra ordenCompra) {
        if(!ordenCompraRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        ordenCompra.setId(id);
        OrdenCompra ordenCompraActualizado = ordenCompraRepository.save(ordenCompra);
        return ResponseEntity.ok(ordenCompraActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrdenCompra(@PathVariable Long id){
        if(!ordenCompraRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        ordenCompraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
