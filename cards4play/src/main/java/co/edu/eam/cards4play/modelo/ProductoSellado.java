package co.edu.eam.cards4play.modelo;

public class ProductoSellado extends Producto {

    public ProductoSellado(String nombre, double precioUsd) {
        super(nombre, precioUsd);
    }

    @Override
    public String getTipo() { return "SELLADO"; }
}
