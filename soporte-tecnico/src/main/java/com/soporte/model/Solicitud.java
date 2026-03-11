package com.soporte.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Solicitud {

    private Integer id;
    private String titulo;
    private String descripcion;
    private String prioridad; // ALTA, MEDIA, BAJA
    private EstadoSolicitud estado;
    private Long clienteId;
    private Long tecnicoId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

}
