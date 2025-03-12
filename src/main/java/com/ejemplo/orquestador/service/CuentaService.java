package com.ejemplo.orquestador.service;

import com.ejemplo.orquestador.entity.Cuenta;
import com.ejemplo.orquestador.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Transactional
    public Cuenta crearCuenta(Cuenta cuenta) {
        if (cuentaRepository.existsByNumeroCuenta(cuenta.getNumeroCuenta())) {
            throw new IllegalArgumentException("La cuenta con el número " + cuenta.getNumeroCuenta() + " ya existe.");
        }
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    @Transactional
    public Cuenta actualizarCuenta(Long id, Cuenta cuentaActualizada) {
        if (!cuentaRepository.existsById(id)) {
            throw new IllegalArgumentException("La cuenta con ID " + id + " no existe.");
        }
        cuentaActualizada.setId(id);
        return cuentaRepository.save(cuentaActualizada);
    }

    @Transactional
    public void eliminarCuenta(Long id) {
        if (!cuentaRepository.existsById(id)) {
            throw new IllegalArgumentException("La cuenta con ID " + id + " no existe.");
        }
        cuentaRepository.deleteById(id);
    }
}
