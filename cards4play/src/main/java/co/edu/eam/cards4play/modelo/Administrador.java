package co.edu.eam.cards4play.modelo;

/**
 * Administrador del sistema. Crear clientes, productos, boosters y torneos
 * lo hacen los servicios, que validan que el usuario sea ADMIN.
 */
public class Administrador extends Usuario {

    public Administrador(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena, Rol.ADMIN);
    }
}
