package com.ejemplo.orquestador.client;

import com.ejemplo.orquestador.entity.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente-service", url = "${clienteservice.url}")
public interface ClienteClient {

    @GetMapping("/clientes/{id}")
    Cliente getCliente(@PathVariable("id") Long id);
}
