package com.ejemplo.orquestador.service;

import com.ejemplo.orquestador.entity.Movimiento;
import com.ejemplo.orquestador.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    public Movimiento findById(Long id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
    }

    public Movimiento create(Movimiento movimiento) {
        if (movimientoRepository.existsByMontoAndTipoAndCuenta(movimiento.getMonto(), movimiento.getTipo(), movimiento.getCuenta())) {
            throw new RuntimeException("Movimiento duplicado");
        }
        return movimientoRepository.save(movimiento);
    }

    public Movimiento update(Long id, Movimiento movimiento) {
        Movimiento existingMovimiento = findById(id);
        existingMovimiento.setMonto(movimiento.getMonto());
        existingMovimiento.setTipo(movimiento.getTipo());
        existingMovimiento.setCuenta(movimiento.getCuenta());
        return movimientoRepository.save(existingMovimiento);
    }

    public void delete(Long id) {
        movimientoRepository.deleteById(id);
    }
}
