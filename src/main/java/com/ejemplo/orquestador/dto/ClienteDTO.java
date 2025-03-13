package com.ejemplo.orquestador.dto;

import com.ejemplo.orquestador.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String email;
    private Date creationDate;
    private Date modificationDate;

    // Constructor vacío
    public ClienteDTO() {}

    // Constructor con parámetros
    public ClienteDTO(Long id, String nombre, String email, Date creationDate, Date modificationDate) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public static ClienteDTO fromEntity(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getCreationDate(),
                cliente.getModificationDate()
        );
    }

    public static Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setCreationDate(clienteDTO.getCreationDate());
        cliente.setModificationDate(clienteDTO.getModificationDate());
        return cliente;
    }
}
