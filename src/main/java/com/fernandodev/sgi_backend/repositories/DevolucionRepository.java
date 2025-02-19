package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion, Long> {}
