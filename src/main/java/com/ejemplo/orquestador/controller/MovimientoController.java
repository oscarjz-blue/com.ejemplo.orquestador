package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.entity.Movimiento;
import com.ejemplo.orquestador.service.MovimientoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movimiento encontrado"),
            @ApiResponse(code = 404, message = "Movimiento no encontrado")
    })
    public ResponseEntity<Movimiento> getById(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.findById(id);
        return ResponseEntity.ok(movimiento);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Movimiento creado"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta")
    })
    public ResponseEntity<Movimiento> create(@RequestBody Movimiento movimiento) {
        Movimiento createdMovimiento = movimientoService.create(movimiento);
        return ResponseEntity.status(201).body(createdMovimiento);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movimiento actualizado"),
            @ApiResponse(code = 404, message = "Movimiento no encontrado"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta")
    })
    public ResponseEntity<Movimiento> update(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        Movimiento updatedMovimiento = movimientoService.update(id, movimiento);
        return ResponseEntity.ok(updatedMovimiento);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Movimiento eliminado"),
            @ApiResponse(code = 404, message = "Movimiento no encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movimientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
