package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {}
