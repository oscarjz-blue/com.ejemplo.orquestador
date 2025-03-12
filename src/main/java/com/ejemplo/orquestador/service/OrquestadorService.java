package com.ejemplo.orquestador.service;

import com.ejemplo.orquestador.client.ClienteClient;
import com.ejemplo.orquestador.client.CuentaClient;
import com.ejemplo.orquestador.client.MovimientosClient;
import com.ejemplo.orquestador.dto.DetalleMovClienteDTO;
import com.ejemplo.orquestador.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrquestadorService {

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private CuentaClient cuentaClient;

    @Autowired
    private MovimientosClient movimientosClient;

    public DetalleMovClienteDTO obtenerDetalleCliente(Long clienteId) {
       Cliente cliente = clienteClient.getCliente(clienteId);
       /*  Cuenta cuenta = cuentaClient.getCuentaByCliente(cliente.getId());
        List<Movimiento> movimientos = movimientosClient.getMovimientos(cuenta.getId());*/

        return null;
    }
}