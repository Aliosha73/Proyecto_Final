package co.edu.eam.cards4play.modelo;

import co.edu.eam.cards4play.excepciones.SolicitudInvalidaException;
import java.util.UUID;

public abstract class Producto {
    private String id;
    private String nombre;
    private double precioUsd;
    private double precioCop;

    protected Producto(String nombre, double precioUsd) {
        validar(nombre, precioUsd);
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.precioUsd = precioUsd;
    }

    private static void validar(String nombre, double precioUsd) {
        if (nombre == null || nombre.isBlank()) {
            throw new SolicitudInvalidaException("El nombre del producto es obligatorio");
        }
        if (precioUsd <= 0) {
            throw new SolicitudInvalidaException("El precio en USD debe ser mayor que cero");
        }
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecioUsd() { return precioUsd; }
    public double getPrecioCop() { return precioCop; }

    public void actualizar(String nombre, double precioUsd) {
        validar(nombre, precioUsd);
        this.nombre = nombre;
        this.precioUsd = precioUsd;
        this.precioCop = 0; // hay que volver a convertir con la tasa vigente
    }

    /** Calcula el precio en pesos a partir del precio en USD y la tasa dada. */
    public void convertirPrecio(double tasa) {
        if (tasa <= 0) {
            throw new SolicitudInvalidaException("La tasa de cambio debe ser mayor que cero");
        }
        this.precioCop = precioUsd * tasa;
    }

    /** Los boosters vendidos dejan de estar disponibles; el resto siempre lo está. */
    public boolean estaDisponible() {
        return true;
    }

    /** "CARTA", "BOOSTER", "SELLADO" o "ACCESORIO" (útil para el JSON). */
    public abstract String getTipo();
}
