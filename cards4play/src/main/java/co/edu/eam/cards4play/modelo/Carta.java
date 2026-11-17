package co.edu.eam.cards4play.modelo;

import co.edu.eam.cards4play.excepciones.SolicitudInvalidaException;

public class Carta extends Producto {
    private Rareza rareza;

    public Carta(String nombre, Rareza rareza, double precioUsd) {
        super(nombre, precioUsd);
        if (rareza == null) {
            throw new SolicitudInvalidaException("La rareza es obligatoria");
        }
        this.rareza = rareza;
    }

    public Rareza getRareza() { return rareza; }

    @Override
    public String getTipo() { return "CARTA"; }
}
