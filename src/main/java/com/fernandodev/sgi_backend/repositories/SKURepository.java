package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.SKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SKURepository extends JpaRepository<SKU, Long> {}
