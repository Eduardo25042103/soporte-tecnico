package com.soporte.service;

import com.soporte.dto.SolicitudDto;
import com.soporte.model.EstadoSolicitud;
import com.soporte.model.Solicitud;

import java.util.List;
import java.util.Optional;

public interface SolicitudService {
    Solicitud create(SolicitudDto solicitudDto);
    List<Solicitud> getAll();
    Optional<Solicitud> getById(int id);
    List<Solicitud> getByCliente(int idCliente);
    List<Solicitud> getByStatus(EstadoSolicitud estadoSolicitud);
    Solicitud update(int id,  SolicitudDto solicitudDto);
    Solicitud updateStatus(int id, EstadoSolicitud estadoSolicitud);
    void delete(int id);
}
