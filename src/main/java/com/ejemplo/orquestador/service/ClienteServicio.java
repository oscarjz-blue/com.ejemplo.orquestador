package com.ejemplo.orquestador.service;

import com.ejemplo.orquestador.entity.Cliente;
import com.ejemplo.orquestador.exceptions.RecursoDuplicadoException;
import com.ejemplo.orquestador.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> obtenerTodos() {
        return clienteRepositorio.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    public Cliente crear(Cliente cliente) {
        // Validar duplicados
        if (clienteRepositorio.existsByEmail(cliente.getEmail())) {
            throw new RecursoDuplicadoException("El email ya está registrado");
        }
        return clienteRepositorio.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        if (!clienteRepositorio.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        cliente.setId(id);
        return clienteRepositorio.save(cliente);
    }

    public void eliminar(Long id) {
        if (!clienteRepositorio.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        clienteRepositorio.deleteById(id);
    }
}
