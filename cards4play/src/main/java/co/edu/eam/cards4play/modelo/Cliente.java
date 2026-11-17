package co.edu.eam.cards4play.modelo;

import co.edu.eam.cards4play.excepciones.ConflictoException;
import co.edu.eam.cards4play.excepciones.RecursoNoEncontradoException;
import co.edu.eam.cards4play.excepciones.SolicitudInvalidaException;
import java.util.List;

public class Cliente extends Usuario {
    private String nombre;
    private InventarioCliente inventario = new InventarioCliente();

    public Cliente(String nombre, String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena, Rol.CLIENTE);
        if (nombre == null || nombre.isBlank()) {
            throw new SolicitudInvalidaException("El nombre del cliente es obligatorio");
        }
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public InventarioCliente getInventario() { return inventario; }

    /** Agrega el producto al inventario. Si es un booster, lo marca como vendido. */
    public void comprar(Producto producto) {
        if (!producto.estaDisponible()) {
            throw new ConflictoException("El producto " + producto.getNombre() + " ya no está disponible");
        }
        if (producto instanceof Booster b) {
            b.marcarVendido();
        }
        inventario.agregar(producto);
    }

    public List<Carta> abrirBooster(String idBooster) {
        Booster booster = inventario.buscarBooster(idBooster)
                .orElseThrow(() -> new RecursoNoEncontradoException("No tienes un booster con ese id"));
        return booster.abrir(this);
    }

    public void inscribirseTorneo(Torneo torneo) {
        torneo.inscribir(this);
    }

    public List<Producto> verInventario() {
        return inventario.listarProductos();
    }
}
