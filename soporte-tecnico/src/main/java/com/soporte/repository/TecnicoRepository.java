package com.soporte.repository;

import com.soporte.model.Tecnico;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TecnicoRepository {
    private final Map<Integer, Tecnico> tecnicos = new HashMap<>();
    private final AtomicInteger secuencialTecnico = new AtomicInteger(1);

    public Tecnico crear(Tecnico tecnico) {
        if (tecnico.getId() == null) {
            tecnico.setId(secuencialTecnico.getAndIncrement());
        }
        tecnicos.put(tecnico.getId(), tecnico);
        return tecnico;
    }

    public List<Tecnico> getAll() {
        return new ArrayList<>(tecnicos.values());
    }

    public Optional<Tecnico> searchById(int id) {
        return Optional.ofNullable(tecnicos.get(id));
    }

    public List<Tecnico> getAvailableTecnicos() {
        List<Tecnico> tecnicos = new ArrayList<>();
        for (Tecnico tecnico : this.tecnicos.values()) {
            if (tecnico.isDisponible()) {
                tecnicos.add(tecnico);
            }
        }
        return tecnicos;
    }

    public Tecnico update(int id, Tecnico tecnico) {
        searchById(id).orElseThrow(
                () -> new RuntimeException("Tecnico no encontrado: " + id)
        );
        tecnico.setId(id);
        tecnicos.put(id, tecnico);
        return tecnico;
    }

    public void delete(int id) {
        searchById(id).orElseThrow(()  -> new RuntimeException("Tecnico no encontrado: " + id));
        tecnicos.remove(id);
    }
}
