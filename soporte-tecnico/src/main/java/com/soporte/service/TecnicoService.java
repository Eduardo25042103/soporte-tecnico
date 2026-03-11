package com.soporte.service;

import com.soporte.dto.TecnicoDto;
import com.soporte.model.Tecnico;
import java.util.List;
import java.util.Optional;

public interface TecnicoService {
    List<Tecnico> obtenerTodos();
    Optional<Tecnico> obtenerPorId(int id);
    List<Tecnico> obtenerDisponibles();
    Tecnico crear(TecnicoDto tecnicoDto);
    Tecnico actualizar(int id, TecnicoDto tecnicoDto);
    void eliminar(int id);
}