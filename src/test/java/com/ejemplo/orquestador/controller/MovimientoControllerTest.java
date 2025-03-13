package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.entity.Movimiento;
import com.ejemplo.orquestador.service.MovimientoService;
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

class MovimientoControllerTest {
    @Mock
    MovimientoService movimientoService;
    @InjectMocks
    MovimientoController movimientoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        Movimiento movimiento = new Movimiento();
        when(movimientoService.findAll()).thenReturn(List.of(movimiento));

        List<Movimiento> result = movimientoController.getAll();
        Assertions.assertEquals(List.of(movimiento), result);
    }

    @Test
    void testGetById() {
        when(movimientoService.findById(anyLong())).thenReturn(new Movimiento());

        ResponseEntity<Movimiento> result = movimientoController.getById(Long.valueOf(1));
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testCreate() {
        when(movimientoService.create(any(Movimiento.class))).thenReturn(new Movimiento());

        ResponseEntity<Movimiento> result = movimientoController.create(new Movimiento());
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void testUpdate() {
        when(movimientoService.update(anyLong(), any(Movimiento.class))).thenReturn(new Movimiento());

        ResponseEntity<Movimiento> result = movimientoController.update(Long.valueOf(1), new Movimiento());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testDelete() {
        ResponseEntity<Void> result = movimientoController.delete(Long.valueOf(1));
        verify(movimientoService).delete(anyLong());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
}
