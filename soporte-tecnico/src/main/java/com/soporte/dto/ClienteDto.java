package com.soporte.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDto {
    @Valid
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @Email(message = "El correo debe tener formato valido")
    @NotBlank(message = "El correo no puede estar vacio")
    private String correo;

    @NotBlank(message = "El telefono no puede estar vacio")
    private String telefono;

    @NotBlank(message = "La empresa no puede estar vacia")
    private String empresa;
}
