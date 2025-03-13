package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.entity.Cuenta;
import com.ejemplo.orquestador.service.CuentaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;

class CuentaControllerTest {
    @Mock
    CuentaService cuentaService;
    @InjectMocks
    CuentaController cuentaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearCuenta() {
        when(cuentaService.crearCuenta(any(Cuenta.class))).thenReturn(new Cuenta());

        ResponseEntity<Cuenta> result = cuentaController.crearCuenta(new Cuenta());
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void testObtenerCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);
        when(cuentaService.obtenerCuentaPorId(anyLong())).thenReturn(Optional.of(cuenta));

        ResponseEntity<Cuenta> result = cuentaController.obtenerCuenta(Long.valueOf(1));
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testActualizarCuenta() {
        when(cuentaService.actualizarCuenta(anyLong(), any(Cuenta.class))).thenReturn(new Cuenta());

        ResponseEntity<Cuenta> result = cuentaController.actualizarCuenta(Long.valueOf(1), new Cuenta());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testEliminarCuenta() {
        ResponseEntity<Void> result = cuentaController.eliminarCuenta(Long.valueOf(1));
        verify(cuentaService).eliminarCuenta(anyLong());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
}

