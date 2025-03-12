package com.fernandodev.sgi_backend.services;


import com.fernandodev.sgi_backend.models.Usuario;
import com.fernandodev.sgi_backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario empleado) {
        return usuarioRepository.save(empleado);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}