package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.ReciboPago;
import com.fernandodev.sgi_backend.repositories.ReciboPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recibos-pago")
public class ReciboPagoController {
    @Autowired
    ReciboPagoRepository reciboPagoRepository;

    @GetMapping
    public List<ReciboPago> listarReciboPagos(){
        return reciboPagoRepository.findAll();
    }

    @PostMapping
    public ReciboPago agregarReciboPago(@RequestBody ReciboPago reciboPago) {
        return reciboPagoRepository.save(reciboPago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReciboPago> obtenerPorId(@PathVariable Long id){
        Optional<ReciboPago> reciboPago = reciboPagoRepository.findById(id);
        return reciboPago.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReciboPago> actualizarReciboPago(@PathVariable Long id, @RequestBody ReciboPago reciboPago) {
        if(!reciboPagoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        reciboPago.setId(id);
        ReciboPago reciboPagoActualizado = reciboPagoRepository.save(reciboPago);
        return ResponseEntity.ok(reciboPagoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReciboPago(@PathVariable Long id){
        if(!reciboPagoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        reciboPagoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
