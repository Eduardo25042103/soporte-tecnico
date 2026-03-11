package com.soporte.service;

import com.soporte.dto.ClienteDto;
import com.soporte.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente crear(ClienteDto clienteDto);
    List<Cliente> listar();
    Optional<Cliente> obtenerPorId(int id);
    Cliente actualizar(int id, ClienteDto clienteDto);
    void eliminar(int id);
}
