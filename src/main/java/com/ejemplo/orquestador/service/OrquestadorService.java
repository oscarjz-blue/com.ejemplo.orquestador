package com.ejemplo.orquestador.service;

import com.ejemplo.orquestador.client.ClienteClient;
import com.ejemplo.orquestador.dto.ClienteDTO;
import com.ejemplo.orquestador.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrquestadorService {

    @Autowired
    private ClienteClient clienteClient;
/*
    @Autowired
    private CuentaClient cuentaClient;

    @Autowired
    private MovimientosClient movimientosClient;*/

    public ClienteDTO obtenerClienteById(Long clienteId) {
       Cliente cliente = clienteClient.getCliente(clienteId);
        ClienteDTO clienteDTO = ClienteDTO.fromEntity(cliente);
        return clienteDTO != null ? clienteDTO : null;
    }

}