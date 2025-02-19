package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Venta;
import com.fernandodev.sgi_backend.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    VentaRepository ventaRepository;

    @GetMapping
    public List<Venta> listarVentas(){
        return ventaRepository.findAll();
    }

    @PostMapping
    public Venta agregarVenta(@RequestBody Venta venta) {
        return ventaRepository.save(venta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerPorId(@PathVariable Long id){
        Optional<Venta> venta = ventaRepository.findById(id);
        return venta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        if(!ventaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        venta.setId(id);
        Venta ventaActualizado = ventaRepository.save(venta);
        return ResponseEntity.ok(ventaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id){
        if(!ventaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        ventaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
