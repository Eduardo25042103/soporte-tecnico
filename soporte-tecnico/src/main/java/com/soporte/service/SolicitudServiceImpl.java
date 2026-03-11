package com.soporte.service;

import com.soporte.dto.SolicitudDto;
import com.soporte.model.EstadoSolicitud;
import com.soporte.model.Solicitud;
import com.soporte.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {
    private final SolicitudRepository solicitudRepository;

    @Override
    public Solicitud create(SolicitudDto solicitudDto) {
        Solicitud solicitud = Solicitud.builder()
                .titulo(solicitudDto.getTitulo())
                .descripcion(solicitudDto.getDescripcion())
                .estado(solicitudDto.getEstado())
                .clienteId(solicitudDto.getClienteId())
                .tecnicoId(solicitudDto.getTecnicoId())
                .fechaCreacion(LocalDateTime.now())
                .build();
        return solicitudRepository.crear(solicitud);
    }
    @Override
    public List<Solicitud> getAll() {
        return solicitudRepository.getAll();
    }
    @Override
    public Optional<Solicitud> getById(int id) {
        return solicitudRepository.searchById(id);
    }
    @Override
    public List<Solicitud> getByCliente(int idCliente) {
        return solicitudRepository.searchByCliente(idCliente);
    }
    @Override
    public List<Solicitud> getByStatus(EstadoSolicitud estadoSolicitud) {
        return solicitudRepository.searchByStatus(estadoSolicitud);
    }
    @Override
    public Solicitud update(int id,  SolicitudDto solicitudDto) {
        Solicitud solicitud = Solicitud.builder()
                .titulo(solicitudDto.getTitulo())
                .descripcion(solicitudDto.getDescripcion())
                .estado(solicitudDto.getEstado())
                .clienteId(solicitudDto.getClienteId())
                .tecnicoId(solicitudDto.getTecnicoId())
                .fechaCreacion(LocalDateTime.now())
                .build();
        return solicitudRepository.update(id, solicitud);
    }
    @Override
    public Solicitud updateStatus(int id, EstadoSolicitud estadoSolicitud) {
        return solicitudRepository.updateStatus(id, estadoSolicitud);
    }
    @Override
    public void delete(int id) {
        solicitudRepository.delete(id);
    }
}
