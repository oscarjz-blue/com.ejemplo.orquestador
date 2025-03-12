package com.ejemplo.orquestador.dto;

import java.util.List;

public class DetalleMovClienteDTO {

    private String clienteId;
    private String nombreCliente;
    private String cuentaId;
    private String tipoCuenta;
    private List<MovimientoDTO> movimientos;

    // Constructor
    public DetalleMovClienteDTO(String clienteId, String nombreCliente, String cuentaId, String tipoCuenta, List<MovimientoDTO> movimientos) {
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
        this.cuentaId = cuentaId;
        this.tipoCuenta = tipoCuenta;
        this.movimientos = movimientos;
    }

    // Getters y Setters
    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public List<MovimientoDTO> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDTO> movimientos) {
        this.movimientos = movimientos;
    }
}

