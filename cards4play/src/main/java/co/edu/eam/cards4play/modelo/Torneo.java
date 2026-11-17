package co.edu.eam.cards4play.modelo;

import co.edu.eam.cards4play.excepciones.ConflictoException;
import co.edu.eam.cards4play.excepciones.SolicitudInvalidaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Torneo {
    private String id;
    private String nombre;
    private LocalDate fecha;
    private int maxParticipantes;
    private List<Cliente> participantes = new ArrayList<>();

    public Torneo(String nombre, LocalDate fecha, int maxParticipantes) {
        if (nombre == null || nombre.isBlank()) {
            throw new SolicitudInvalidaException("El nombre del torneo es obligatorio");
        }
        if (fecha == null) {
            throw new SolicitudInvalidaException("La fecha del torneo es obligatoria");
        }
        if (maxParticipantes <= 0) {
            throw new SolicitudInvalidaException("El máximo de participantes debe ser mayor que cero");
        }
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.fecha = fecha;
        this.maxParticipantes = maxParticipantes;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public LocalDate getFecha() { return fecha; }
    public int getMaxParticipantes() { return maxParticipantes; }
    public List<Cliente> getParticipantes() { return Collections.unmodifiableList(participantes); }

    public boolean hayCupo() {
        return participantes.size() < maxParticipantes;
    }

    public int getCuposDisponibles() {
        return maxParticipantes - participantes.size();
    }

    public void inscribir(Cliente cliente) {
        if (participantes.stream().anyMatch(c -> c.getId().equals(cliente.getId()))) {
            throw new ConflictoException("El cliente ya está inscrito en este torneo");
        }
        if (!hayCupo()) {
            throw new ConflictoException("El torneo no tiene cupos disponibles");
        }
        participantes.add(cliente);
    }
}
