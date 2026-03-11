package com.soporte.service;

import com.soporte.dto.ClienteDto;
import com.soporte.model.Cliente;
import com.soporte.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public Cliente crear(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .correo(clienteDto.getCorreo())
                .empresa(clienteDto.getEmpresa())
                .telefono(clienteDto.getTelefono())
                .build();
        return clienteRepository.crear(cliente);
    }
    @Override
    public List<Cliente> listar() {
        return clienteRepository.getAll();
    }
    @Override
    public Optional<Cliente> obtenerPorId(int id) {
        return clienteRepository.searchById(id);
    }
    @Override
    public Cliente actualizar(int id, ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .correo(clienteDto.getCorreo())
                .empresa(clienteDto.getEmpresa())
                .telefono(clienteDto.getTelefono())
                .build();
        return clienteRepository.update(id, cliente);
    }
    @Override
    public void eliminar(int id) {
        clienteRepository.delete(id);
    }
}
