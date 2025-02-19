package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.Devolucion;
import com.fernandodev.sgi_backend.repositories.DevolucionRepository;
import com.fernandodev.sgi_backend.repositories.DevolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevolucionService {
    @Autowired
    private DevolucionRepository devolucionRepository;

    public List<Devolucion> findAll() {
        return devolucionRepository.findAll();
    }

    public Optional<Devolucion> findById(Long id) {
        return devolucionRepository.findById(id);
    }

    public Devolucion save(Devolucion devolucion) {
        return devolucionRepository.save(devolucion);
    }

    public void deleteById(Long id) {
        devolucionRepository.deleteById(id);
    }
}
