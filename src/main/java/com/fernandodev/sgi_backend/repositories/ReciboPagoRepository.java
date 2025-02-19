package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.ReciboPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciboPagoRepository extends JpaRepository<ReciboPago, Long> {}
