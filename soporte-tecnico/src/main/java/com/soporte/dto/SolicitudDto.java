package com.soporte.dto;

import com.soporte.model.EstadoSolicitud;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SolicitudDto {
    @Valid
    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    @NotBlank(message = "La prioridad no puede estar vacía")
    private String prioridad; // ALTA, MEDIA, BAJA
    private EstadoSolicitud estado;
    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;
    private Long tecnicoId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
