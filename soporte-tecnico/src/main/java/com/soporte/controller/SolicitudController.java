package com.soporte.controller;

import com.soporte.dto.SolicitudDto;
import com.soporte.model.EstadoSolicitud;
import com.soporte.model.Solicitud;
import com.soporte.service.SolicitudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService solicitudService;

    @GetMapping
    public List<Solicitud> obtenerTodas() {
        return solicitudService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtenerPorId(@PathVariable int id) {
        return solicitudService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Solicitud> obtenerPorCliente(@PathVariable int clienteId) {
        return solicitudService.getByCliente(clienteId);
    }

    @GetMapping("/estado/{estado}")
    public List<Solicitud> obtenerPorEstado(@PathVariable EstadoSolicitud estado) {
        return solicitudService.getByStatus(estado);
    }

    @PostMapping
    public ResponseEntity<Solicitud> crear(@Valid @RequestBody SolicitudDto solicitudDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(solicitudService.create(solicitudDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable int id,
                                                @Valid @RequestBody SolicitudDto solicitudDto) {
        return ResponseEntity.ok(solicitudService.update(id, solicitudDto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Solicitud> cambiarEstado(@PathVariable int id,
                                                   @RequestParam EstadoSolicitud nuevoEstado) {
        return ResponseEntity.ok(solicitudService.updateStatus(id, nuevoEstado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        solicitudService.delete(id);
        return ResponseEntity.noContent().build();
    }
}