package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {}
