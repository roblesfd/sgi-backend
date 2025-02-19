package com.fernandodev.sgi_backend.services;


import com.fernandodev.sgi_backend.models.Oferta;
import com.fernandodev.sgi_backend.repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaService {
    @Autowired
    private OfertaRepository ofertaRepository;

    public List<Oferta> findAll() {
        return ofertaRepository.findAll();
    }

    public Optional<Oferta> findById(Long id) {
        return ofertaRepository.findById(id);
    }

    public Oferta save(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    public void deleteById(Long id) {
        ofertaRepository.deleteById(id);
    }
}