package com.soporte.controller;

import com.soporte.dto.ClienteDto;
import com.soporte.model.Cliente;
import com.soporte.service.ClienteService;
import com.soporte.service.ClienteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clientService;

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodos() {
        return ResponseEntity.ok(clientService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable int id) {
        return clientService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@Valid @RequestBody ClienteDto clienteDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientService.crear(clienteDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable int id,
                                              @Valid @RequestBody ClienteDto clienteDto) {
        return ResponseEntity.ok(clientService.actualizar(id, clienteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        clientService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}