package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {}
