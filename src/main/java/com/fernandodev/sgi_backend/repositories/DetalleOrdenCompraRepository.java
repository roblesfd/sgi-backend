package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.DetalleOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompra, Long> {}
