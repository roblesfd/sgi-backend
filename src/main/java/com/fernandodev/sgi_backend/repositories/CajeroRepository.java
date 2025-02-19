package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Cajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajeroRepository extends JpaRepository<Cajero, Long> {}
