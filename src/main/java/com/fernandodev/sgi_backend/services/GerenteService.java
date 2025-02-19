package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.Gerente;
import com.fernandodev.sgi_backend.repositories.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository gerenteRepository;

    public List<Gerente> findAll() {
        return gerenteRepository.findAll();
    }

    public Optional<Gerente> findById(Long id) {
        return gerenteRepository.findById(id);
    }

    public Gerente save(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    public void deleteById(Long id) {
        gerenteRepository.deleteById(id);
    }
}
