package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.Reporte;
import com.fernandodev.sgi_backend.repositories.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> findAll() {
        return reporteRepository.findAll();
    }

    public Optional<Reporte> findById(Long id) {
        return reporteRepository.findById(id);
    }

    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public void deleteById(Long id) {
        reporteRepository.deleteById(id);
    }
}
