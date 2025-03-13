package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.entity.Cliente;
import com.ejemplo.orquestador.service.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

class ClienteControladorTest {
    @Mock
    ClienteServicio clienteServicio;
    @InjectMocks
    ClienteControlador clienteControlador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerTodos() {
        Cliente cliente = new Cliente();
        when(clienteServicio.obtenerTodos()).thenReturn(List.of(cliente));

        List<Cliente> result = clienteControlador.obtenerTodos();
        Assertions.assertEquals(List.of(cliente), result);
    }

    @Test
    void testObtenerPorId() {
        when(clienteServicio.obtenerPorId(anyLong())).thenReturn(new Cliente());

        ResponseEntity<Cliente> result = clienteControlador.obtenerPorId(Long.valueOf(1));
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testCrear() {
        when(clienteServicio.crear(any(Cliente.class))).thenReturn(new Cliente());

        ResponseEntity<Cliente> result = clienteControlador.crear(new Cliente());
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void testActualizar() {
        when(clienteServicio.actualizar(anyLong(), any(Cliente.class))).thenReturn(new Cliente());

        ResponseEntity<Cliente> result = clienteControlador.actualizar(Long.valueOf(1), new Cliente());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testEliminar() {
        ResponseEntity<Void> result = clienteControlador.eliminar(Long.valueOf(1));
        verify(clienteServicio).eliminar(anyLong());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
}
