package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.entity.Cliente;
import com.ejemplo.orquestador.service.ClienteServicio;
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

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un cliente por ID", response = Cliente.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente encontrado"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Long id) {
        Cliente cliente = clienteServicio.obtenerPorId(id);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente creado exitosamente"),
            @ApiResponse(code = 409, message = "El email ya esta registrado")
    })
    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteServicio.crear(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }
    @Operation(summary = "Actualizar un cliente", description = "Actualiza los detalles de un cliente existente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente actualizado exitosamente"),
            @ApiResponse(code = 400, message = "Petición incorrecta"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteServicio.actualizar(id, cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un cliente por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Cliente eliminado exitosamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
