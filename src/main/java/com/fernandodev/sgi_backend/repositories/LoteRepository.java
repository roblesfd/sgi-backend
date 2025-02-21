package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {}
