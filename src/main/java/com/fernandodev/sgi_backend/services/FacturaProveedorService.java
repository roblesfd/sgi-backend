package com.fernandodev.sgi_backend.services;


import com.fernandodev.sgi_backend.models.FacturaProveedor;
import com.fernandodev.sgi_backend.repositories.FacturaProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaProveedorService {
    @Autowired
    private FacturaProveedorRepository facturaProveedorRepository;

    public List<FacturaProveedor> findAll() {
        return facturaProveedorRepository.findAll();
    }

    public Optional<FacturaProveedor> findById(Long id) {
        return facturaProveedorRepository.findById(id);
    }

    public FacturaProveedor save(FacturaProveedor facturaProveedor) {
        return facturaProveedorRepository.save(facturaProveedor);
    }

    public void deleteById(Long id) {
        facturaProveedorRepository.deleteById(id);
    }
}