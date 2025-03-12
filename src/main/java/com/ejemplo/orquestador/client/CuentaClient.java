package com.ejemplo.orquestador.client;

import com.ejemplo.orquestador.entity.Cuenta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cuenta-service", url = "${cuentaservice.url}")
public interface CuentaClient {

    @GetMapping("/cuentas/cliente/{id}")
    Cuenta getCuentaByCliente(@PathVariable("id") Long id);
}
