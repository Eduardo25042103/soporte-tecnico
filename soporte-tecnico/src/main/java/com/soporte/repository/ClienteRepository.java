package com.soporte.repository;

import com.soporte.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ClienteRepository {
    private final Map<Integer, Cliente> clientes = new HashMap<>();
    private final AtomicInteger secuencialCliente = new AtomicInteger(1);

    public Cliente crear(Cliente cliente) {
        if (cliente.getIdCliente() == null) {
            cliente.setIdCliente(secuencialCliente.getAndIncrement());
        }
        clientes.put(cliente.getIdCliente(), cliente);
        return cliente;
    }

    public List<Cliente> getAll() {
        return new ArrayList<>(clientes.values());
    }

    public Optional<Cliente> searchById(int id) {
        return Optional.ofNullable(clientes.get(id));
    }

    public Cliente update(int id, Cliente cliente) {
        searchById(id).orElseThrow(
                () -> new RuntimeException("Cliente no encontrado: " + id)
        );
        cliente.setIdCliente(id);
        clientes.put(id, cliente);
        return cliente;
    }

    public void delete(int id) {
        searchById(id).orElseThrow(()  -> new RuntimeException("Cliente no encontrado: " + id));
        clientes.remove(id);
    }
}
