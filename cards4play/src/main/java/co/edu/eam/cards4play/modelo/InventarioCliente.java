package co.edu.eam.cards4play.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/** Productos que un cliente ha comprado. */
public class InventarioCliente {
    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    public boolean contiene(Producto producto) {
        return productos.contains(producto);
    }

    public List<Producto> listarProductos() {
        return Collections.unmodifiableList(productos);
    }

    public List<Booster> listarBoosters() {
        List<Booster> boosters = new ArrayList<>();
        for (Producto p : productos) {
            if (p instanceof Booster b) {
                boosters.add(b);
            }
        }
        return boosters;
    }

    public Optional<Booster> buscarBooster(String id) {
        return listarBoosters().stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}
