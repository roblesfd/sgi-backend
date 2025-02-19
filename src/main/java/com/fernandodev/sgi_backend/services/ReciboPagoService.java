package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.ReciboPago;
import com.fernandodev.sgi_backend.repositories.ReciboPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReciboPagoService {
    @Autowired
    private ReciboPagoRepository reciboPagoRepository;

    public List<ReciboPago> findAll() {
        return reciboPagoRepository.findAll();
    }

    public Optional<ReciboPago> findById(Long id) {
        return reciboPagoRepository.findById(id);
    }

    public ReciboPago save(ReciboPago reciboPago) {
        return reciboPagoRepository.save(reciboPago);
    }

    public void deleteById(Long id) {
        reciboPagoRepository.deleteById(id);
    }
}
