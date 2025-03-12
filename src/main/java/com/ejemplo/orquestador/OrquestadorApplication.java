package com.ejemplo.orquestador;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server Url")})
public class OrquestadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestadorApplication.class, args);
	}

}
