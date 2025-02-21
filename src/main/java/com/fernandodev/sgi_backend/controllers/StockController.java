package com.fernandodev.sgi_backend.controllers;

import com.fernandodev.sgi_backend.models.Stock;
import com.fernandodev.sgi_backend.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    StockRepository stockRepository;

    @GetMapping
    public List<Stock> listarStocks(){
        return stockRepository.findAll();
    }

    @PostMapping
    public Stock agregarStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> obtenerPorId(@PathVariable Long id){
        Optional<Stock> stock = stockRepository.findById(id);
        return stock.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> actualizarStock(@PathVariable Long id, @RequestBody Stock stock) {
        if(!stockRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        stock.setId(id);
        Stock stockActualizado = stockRepository.save(stock);
        return ResponseEntity.ok(stockActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarStock(@PathVariable Long id){
        if(!stockRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        stockRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
