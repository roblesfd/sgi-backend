package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Usuario;
import com.fernandodev.sgi_backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if(!usuarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        if(!usuarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
