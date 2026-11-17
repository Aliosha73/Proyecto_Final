package co.edu.eam.cards4play.modelo;

import co.edu.eam.cards4play.excepciones.SolicitudInvalidaException;
import java.util.UUID;

public abstract class Usuario {
    private String id;
    private String nombreUsuario;
    private String contrasena;
    private Rol rol;

    protected Usuario(String nombreUsuario, String contrasena, Rol rol) {
        if (nombreUsuario == null || nombreUsuario.isBlank()) {
            throw new SolicitudInvalidaException("El nombre de usuario es obligatorio");
        }
        if (contrasena == null || contrasena.isBlank()) {
            throw new SolicitudInvalidaException("La contraseña es obligatoria");
        }
        this.id = UUID.randomUUID().toString();
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public Rol getRol() { return rol; }

    public boolean esAdmin() {
        return rol == Rol.ADMIN;
    }

    /** true si las credenciales corresponden a este usuario. */
    public boolean autenticar(String usuario, String contrasena) {
        return this.nombreUsuario.equals(usuario) && this.contrasena.equals(contrasena);
    }
}
