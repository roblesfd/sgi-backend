package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Categoria;
import com.fernandodev.sgi_backend.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    public Categoria agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        if(!categoriaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        categoria.setId(id);
        Categoria categoriaActualizado = categoriaRepository.save(categoria);
        return ResponseEntity.ok(categoriaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
        if(!categoriaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        categoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
