package com.soporte.service;

import com.soporte.dto.TecnicoDto;
import com.soporte.model.Tecnico;
import com.soporte.repository.TecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TecnicoServiceImpl implements TecnicoService {
    private final TecnicoRepository tecnicoRepository;

    @Override
    public List<Tecnico> obtenerTodos() {
        return tecnicoRepository.getAll();
    }

    @Override
    public Optional<Tecnico> obtenerPorId(int id) {
        return tecnicoRepository.searchById(id);
    }

    @Override
    public List<Tecnico> obtenerDisponibles() {
        return tecnicoRepository.getAvailableTecnicos();
    }

    @Override
    public Tecnico crear(TecnicoDto tecnicoDto) {
        Tecnico tecnico = Tecnico.builder()
                .nombre(tecnicoDto.getNombre())
                .apellido(tecnicoDto.getApellido())
                .correo(tecnicoDto.getCorreo())
                .especialidad(tecnicoDto.getEspecialidad())
                .disponible(tecnicoDto.isDisponible())
                .build();
        return tecnicoRepository.crear(tecnico);
    }

    @Override
    public Tecnico actualizar(int id, TecnicoDto tecnicoDto) {
        Tecnico tecnico = Tecnico.builder()
                .nombre(tecnicoDto.getNombre())
                .apellido(tecnicoDto.getApellido())
                .correo(tecnicoDto.getCorreo())
                .especialidad(tecnicoDto.getEspecialidad())
                .disponible(tecnicoDto.isDisponible())
                .build();
        return tecnicoRepository.update(id, tecnico);
    }

    @Override
    public void eliminar(int id) {
        tecnicoRepository.delete(id);
    }
}