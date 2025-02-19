package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {}
