package com.fernandodev.sgi_backend.services;

import com.fernandodev.sgi_backend.models.SKU;
import com.fernandodev.sgi_backend.repositories.SKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SKUService {
    @Autowired
    private SKURepository skuRepository;

    public List<SKU> findAll() {
        return skuRepository.findAll();
    }

    public Optional<SKU> findById(Long id) {
        return skuRepository.findById(id);
    }

    public SKU save(SKU sku) {
        return skuRepository.save(sku);
    }

    public void deleteById(Long id) {
        skuRepository.deleteById(id);
    }
}
