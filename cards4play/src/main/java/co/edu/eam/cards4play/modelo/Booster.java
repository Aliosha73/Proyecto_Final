package co.edu.eam.cards4play.modelo;

import co.edu.eam.cards4play.excepciones.AccesoDenegadoException;
import co.edu.eam.cards4play.excepciones.ConflictoException;
import co.edu.eam.cards4play.excepciones.SolicitudInvalidaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Booster extends Producto {
    public static final int TAMANO = 10;

    private List<Carta> cartas = new ArrayList<>();
    private boolean vendido;
    private boolean abierto;

    public Booster(String nombre, double precioUsd) {
        super(nombre, precioUsd);
    }

    /** Define las 10 cartas del booster. Se llama una sola vez, al crearlo. */
    public void asignarCartas(List<Carta> cartas) {
        if (cartas == null || cartas.size() != TAMANO) {
            throw new SolicitudInvalidaException("Un booster debe tener exactamente " + TAMANO + " cartas");
        }
        this.cartas = new ArrayList<>(cartas);
    }

    public boolean isVendido() { return vendido; }
    public boolean isAbierto() { return abierto; }

    /** Las cartas solo se ven cuando el booster ya fue abierto. */
    public List<Carta> getCartasVisibles() {
        return abierto ? Collections.unmodifiableList(cartas) : List.of();
    }

    @Override
    public boolean estaDisponible() {
        return !vendido;
    }

    public void marcarVendido() {
        if (vendido) {
            throw new ConflictoException("El booster ya fue vendido");
        }
        this.vendido = true;
    }

    /** Abre el booster. Solo su dueño puede hacerlo y solo una vez. */
    public List<Carta> abrir(Cliente cliente) {
        if (!cliente.getInventario().contiene(this)) {
            throw new AccesoDenegadoException("Este booster no pertenece al cliente");
        }
        if (abierto) {
            throw new ConflictoException("El booster ya fue abierto");
        }
        this.abierto = true;
        return Collections.unmodifiableList(cartas);
    }

    @Override
    public String getTipo() { return "BOOSTER"; }
}
