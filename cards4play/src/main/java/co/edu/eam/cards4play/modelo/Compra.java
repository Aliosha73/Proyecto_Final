package co.edu.eam.cards4play.modelo;

import co.edu.eam.cards4play.excepciones.SolicitudInvalidaException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Compra {
    private String id;
    private Cliente cliente;
    private List<Producto> productos;
    private LocalDateTime fecha;
    private double total; // en COP: suma de precioCop de los productos
    private FuenteTasa fuenteTasa;

    /** Los productos ya deben tener su precioCop calculado antes de comprar. */
    public Compra(Cliente cliente, List<Producto> productos, FuenteTasa fuenteTasa) {
        if (productos == null || productos.isEmpty()) {
            throw new SolicitudInvalidaException("La compra debe incluir al menos un producto");
        }
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.productos = new ArrayList<>(productos);
        this.fecha = LocalDateTime.now();
        this.fuenteTasa = fuenteTasa;
        this.total = calcularTotal();
    }

    public double calcularTotal() {
        double suma = 0;
        for (Producto p : productos) {
            suma += p.getPrecioCop();
        }
        return suma;
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<Producto> getProductos() { return Collections.unmodifiableList(productos); }
    public LocalDateTime getFecha() { return fecha; }
    public double getTotal() { return total; }
    public FuenteTasa getFuenteTasa() { return fuenteTasa; }
}
