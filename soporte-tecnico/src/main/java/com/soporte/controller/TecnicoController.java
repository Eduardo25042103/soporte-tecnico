package com.soporte.controller;

import com.soporte.dto.TecnicoDto;
import com.soporte.model.Tecnico;
import com.soporte.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping
    public List<Tecnico> obtenerTodos() {
        return tecnicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> obtenerPorId(@PathVariable int id) {
        return tecnicoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/disponibles")
    public List<Tecnico> obtenerDisponibles() {
        return tecnicoService.obtenerDisponibles();
    }

    @PostMapping
    public ResponseEntity<Tecnico> crear(@Valid @RequestBody TecnicoDto tecnicoDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tecnicoService.crear(tecnicoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> actualizar(@PathVariable int id,
                                              @Valid @RequestBody TecnicoDto tecnicoDto) {
        return ResponseEntity.ok(tecnicoService.actualizar(id, tecnicoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        tecnicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}