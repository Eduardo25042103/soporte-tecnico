package com.soporte.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tecnico {
    private Integer id;
    private String nombre;
    private String apellido;
    private  String correo;
    private String especialidad;
    private boolean disponible;
}







