package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {}
