package com.ejemplo.orquestador.dto;

class MovimientoDTO {
    private String id;
    private String tipoMovimiento;
    private double monto;
    private String fecha;

    // Constructor
    public MovimientoDTO(String id, String tipoMovimiento, double monto, String fecha) {
        this.id = id;
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}