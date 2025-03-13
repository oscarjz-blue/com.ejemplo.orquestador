package com.ejemplo.orquestador.service;

import com.ejemplo.orquestador.entity.Cliente;
import com.ejemplo.orquestador.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServicioTest {

    @InjectMocks
    private ClienteServicio clienteServicio;

    @Mock
    private ClienteRepository clienteRepositorio;

    @Test
    public void testObtenerClientePorId() {
        // Configurar el comportamiento del mock
        Cliente clienteMock = new Cliente(1L, "Anonimo");
        when(clienteRepositorio.findById(1L)).thenReturn(Optional.of(clienteMock));

        // Llamar al método a probar
        Cliente cliente = clienteServicio.obtenerPorId(1L);

        // Verificar el resultado
        assertNotNull(cliente);
        assertEquals(1L, cliente.getId());
        assertEquals("Anonimo", cliente.getNombre());
    }

    @Test
    public void testCrearCliente() {
        // Configurar el comportamiento del mock
        Cliente clienteMock = new Cliente(2, "Anonimo");
        Cliente clienteGuardado = new Cliente(2L, "Anonimo");
        when(clienteRepositorio.save(clienteMock)).thenReturn(clienteGuardado);

        // Llamar al método a probar
        Cliente cliente = clienteServicio.crear(clienteMock);

        // Verificar el resultado
        assertNotNull(cliente);
        assertEquals(2L, cliente.getId());
        assertEquals("Anonimo", cliente.getNombre());
    }

    @Test
    public void testEliminarClienteNoExistente() {
        assertThrows(RuntimeException.class, () -> {
            clienteServicio.eliminar(1L);
        });
    }

    @Test
    public void testCrearClienteNulo() {
        // Llamar al método a probar con entrada nula y verificar que lanza una excepción
        assertThrows(NullPointerException.class, () -> {
            clienteServicio.crear(null);
        });
    }

    @Test
    public void testObtenerClientePorIdNoEncontrado() {
        // Configurar el comportamiento del mock para que devuelva un Optional vacío
        when(clienteRepositorio.findById(1L)).thenReturn(Optional.empty());

        // Llamar al método a probar y verificar que lanza una excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clienteServicio.obtenerPorId(2L);
        });

        // Verificar que el mensaje de la excepción es el esperado (opcional)
        assertNotNull(exception.getMessage());
    }
}