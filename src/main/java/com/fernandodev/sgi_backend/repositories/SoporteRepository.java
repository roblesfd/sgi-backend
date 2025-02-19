package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoporteRepository extends JpaRepository<Alerta, Long> {}
