package com.ejemplo.orquestador.client;

import com.ejemplo.orquestador.entity.Movimiento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "movimientos-service", url = "${movimientosservice.url}")
public interface MovimientosClient {

    @GetMapping("/movimientos/{cuentaId}")
    List<Movimiento> getMovimientos(@PathVariable("cuentaId") Long cuentaId);
}
