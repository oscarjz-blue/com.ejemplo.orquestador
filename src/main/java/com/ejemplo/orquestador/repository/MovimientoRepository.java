package com.ejemplo.orquestador.repository;

import com.ejemplo.orquestador.entity.Cuenta;
import com.ejemplo.orquestador.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    boolean existsByMontoAndTipoAndCuenta(Double monto, String tipo, Cuenta cuenta);
}
