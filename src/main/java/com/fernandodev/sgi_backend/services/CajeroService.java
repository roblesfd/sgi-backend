package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.Cajero;
import com.fernandodev.sgi_backend.repositories.CajeroRepository;
import com.fernandodev.sgi_backend.repositories.CajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajeroService {
    @Autowired
    private CajeroRepository cajeroRepository;

    public List<Cajero> findAll() {
        return cajeroRepository.findAll();
    }

    public Optional<Cajero> findById(Long id) {
        return cajeroRepository.findById(id);
    }

    public Cajero save(Cajero cajero) {
        return cajeroRepository.save(cajero);
    }

    public void deleteById(Long id) {
        cajeroRepository.deleteById(id);
    }
}
