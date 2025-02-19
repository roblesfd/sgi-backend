package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.FacturaProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaProveedorRepository extends JpaRepository<FacturaProveedor, Long> {}
