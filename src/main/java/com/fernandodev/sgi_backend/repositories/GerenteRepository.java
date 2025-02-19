package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {}
