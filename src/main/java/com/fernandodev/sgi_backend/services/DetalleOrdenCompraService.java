package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.DetalleOrdenCompra;
import com.fernandodev.sgi_backend.repositories.DetalleOrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenCompraService {
    @Autowired
    private DetalleOrdenCompraRepository detalleOrdenCompraRepository;

    public List<DetalleOrdenCompra> findAll() {
        return detalleOrdenCompraRepository.findAll();
    }

    public Optional<DetalleOrdenCompra> findById(Long id) {
        return detalleOrdenCompraRepository.findById(id);
    }

    public DetalleOrdenCompra save(DetalleOrdenCompra detalleOrdenCompra) {
        return detalleOrdenCompraRepository.save(detalleOrdenCompra);
    }

    public void deleteById(Long id) {
        detalleOrdenCompraRepository.deleteById(id);
    }
}
