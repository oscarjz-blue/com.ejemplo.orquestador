package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.entity.Cuenta;
import com.ejemplo.orquestador.service.CuentaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    @ApiOperation(value = "Crear una nueva cuenta", response = Cuenta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cuenta creada exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta, datos inválidos")
    })
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        try {
            Cuenta nuevaCuenta = cuentaService.crearCuenta(cuenta);
            return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener cuenta por ID", response = Cuenta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cuenta encontrada"),
            @ApiResponse(code = 404, message = "Cuenta no encontrada")
    })
    public ResponseEntity<Cuenta> obtenerCuenta(@PathVariable Long id) {
        Optional<Cuenta> cuenta = cuentaService.obtenerCuentaPorId(id);
        return cuenta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar cuenta", description = "Actualiza los detalles de una cuenta específica.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cuenta actualizada exitosamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta, probablemente debido a argumentos inválidos"),
            @ApiResponse(code = 404, message = "Cuenta no encontrada con el ID proporcionado")
    })
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        try {
            Cuenta cuentaActualizada = cuentaService.actualizarCuenta(id, cuenta);
            return ResponseEntity.ok(cuentaActualizada);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cuenta por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Cuenta eliminada exitosamente"),
            @ApiResponse(code = 404, message = "Cuenta no encontrada")
    })
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        try {
            cuentaService.eliminarCuenta(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
