package com.fernandodev.sgi_backend.repositories;

import com.fernandodev.sgi_backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
