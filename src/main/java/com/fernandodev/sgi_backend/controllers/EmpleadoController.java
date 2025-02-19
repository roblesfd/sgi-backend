package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Empleado;
import com.fernandodev.sgi_backend.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> listarEmpleados(){
        return empleadoRepository.findAll();
    }

    @PostMapping
    public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Long id){
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        if(!empleadoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        empleado.setId(id);
        Empleado empleadoActualizado = empleadoRepository.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id){
        if(!empleadoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        empleadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
