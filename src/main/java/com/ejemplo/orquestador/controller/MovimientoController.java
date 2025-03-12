package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.entity.Movimiento;
import com.ejemplo.orquestador.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> getAll() {
        return movimientoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getById(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.findById(id);
        return ResponseEntity.ok(movimiento);
    }

    @PostMapping
    public ResponseEntity<Movimiento> create(@RequestBody Movimiento movimiento) {
        Movimiento createdMovimiento = movimientoService.create(movimiento);
        return ResponseEntity.status(201).body(createdMovimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> update(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        Movimiento updatedMovimiento = movimientoService.update(id, movimiento);
        return ResponseEntity.ok(updatedMovimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movimientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
