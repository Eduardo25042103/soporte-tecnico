package com.soporte.repository;

import com.soporte.model.EstadoSolicitud;
import com.soporte.model.Solicitud;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SolicitudRepository {
    private final Map<Integer, Solicitud> solicitudes = new HashMap<>();
    private final AtomicInteger secuencialSolicitud = new AtomicInteger(1);

    public Solicitud crear(Solicitud solicitud) {
        if (solicitud.getId() == null) {
            solicitud.setId(secuencialSolicitud.getAndIncrement());
        }
        solicitudes.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    public List<Solicitud> getAll() {
        return new ArrayList<>(solicitudes.values());
    }

    public Optional<Solicitud> searchById(int id) {
        return Optional.ofNullable(solicitudes.get(id));
    }

    public List<Solicitud> searchByCliente(int idCliente) {
        return solicitudes.values().stream().filter(s -> s.getClienteId() == idCliente).toList();
    }

    public List<Solicitud> searchByStatus(EstadoSolicitud estadoSolicitud) {
        return solicitudes.values().stream().filter(s -> s.getEstado().equals(estadoSolicitud)).toList();
    }

    public Solicitud update(int id, Solicitud solicitud) {
        searchById(id).orElseThrow(
                () -> new RuntimeException("Solicitud no encontrado: " + id)
        );
        solicitud.setId(id);
        solicitudes.put(id, solicitud);
        return solicitud;
    }

    public Solicitud updateStatus(int id, EstadoSolicitud estadoSolicitud) {
        Solicitud solicitud = searchById(id).orElseThrow(() -> new RuntimeException("Solicitud no encontrado: " + id));
        solicitud.setId(id);
        solicitud.setEstado(estadoSolicitud);
        solicitud.setFechaActualizacion(LocalDateTime.now());
        solicitudes.put(id, solicitud);
        return solicitud;
    }

    public void delete(int id) {
        searchById(id).orElseThrow(()  -> new RuntimeException("Solicitud no encontrado: " + id));
        solicitudes.remove(id);
    }
}
