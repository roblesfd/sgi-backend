package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.Alerta;
import com.fernandodev.sgi_backend.repositories.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {
    @Autowired
    private AlertaRepository alertaRepository;

    public List<Alerta> findAll() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> findById(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta save(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public void deleteById(Long id) {
        alertaRepository.deleteById(id);
    }
}
