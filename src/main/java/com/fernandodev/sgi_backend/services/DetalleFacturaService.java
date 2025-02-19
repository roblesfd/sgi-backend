package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.DetalleFactura;
import com.fernandodev.sgi_backend.repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public List<DetalleFactura> findAll() {
        return detalleFacturaRepository.findAll();
    }

    public Optional<DetalleFactura> findById(Long id) {
        return detalleFacturaRepository.findById(id);
    }

    public DetalleFactura save(DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }

    public void deleteById(Long id) {
        detalleFacturaRepository.deleteById(id);
    }
}
