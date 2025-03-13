package com.ejemplo.orquestador.service;

import com.ejemplo.orquestador.entity.Cliente;
import com.ejemplo.orquestador.exceptions.RecursoDuplicadoException;
import com.ejemplo.orquestador.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente crear(Cliente cliente) {
        // Validar duplicados
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new RecursoDuplicadoException("El email ya esta registrado");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
