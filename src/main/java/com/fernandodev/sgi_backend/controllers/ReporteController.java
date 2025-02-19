package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Reporte;
import com.fernandodev.sgi_backend.repositories.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    ReporteRepository reporteRepository;

    @GetMapping
    public List<Reporte> listarReportes(){
        return reporteRepository.findAll();
    }

    @PostMapping
    public Reporte agregarReporte(@RequestBody Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerPorId(@PathVariable Long id){
        Optional<Reporte> reporte = reporteRepository.findById(id);
        return reporte.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> actualizarReporte(@PathVariable Long id, @RequestBody Reporte reporte) {
        if(!reporteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        reporte.setId(id);
        Reporte reporteActualizado = reporteRepository.save(reporte);
        return ResponseEntity.ok(reporteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReporte(@PathVariable Long id){
        if(!reporteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        reporteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
