package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.dto.ClienteDTO;
import com.ejemplo.orquestador.service.OrquestadorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "OrquestadorController")
@RestController
@RequestMapping("/api/orquestador")
public class OrquestadorController {

    @Autowired
    private OrquestadorService orquestadorService;

    @GetMapping("/clientes/{id}")
    public ClienteDTO obtenerClienteById(@PathVariable Long id) {
        return orquestadorService.obtenerClienteById(id);
    }
}