package com.ejemplo.orquestador.controller;

import com.ejemplo.orquestador.dto.ClienteDTO;
import com.ejemplo.orquestador.service.OrquestadorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.*;

class OrquestadorControllerTest {
    @Mock
    OrquestadorService orquestadorService;
    @InjectMocks
    OrquestadorController orquestadorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerClienteById() {
        ClienteDTO clienteDTO = new ClienteDTO(Long.valueOf(1), "nombre", "email", new GregorianCalendar(2025, Calendar.MARCH, 13, 9, 50).getTime(), new GregorianCalendar(2025, Calendar.MARCH, 13, 9, 50).getTime());
        when(orquestadorService.obtenerClienteById(anyLong())).thenReturn(clienteDTO);

        ClienteDTO result = orquestadorController.obtenerClienteById(Long.valueOf(1));
        Assertions.assertEquals(clienteDTO, result);
    }
}
