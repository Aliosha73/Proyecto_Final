package co.edu.eam.cards4play.excepciones;

/** HTTP 403 */
public class AccesoDenegadoException extends ApiException {
    public AccesoDenegadoException(String mensaje) {
        super(403, mensaje);
    }
}
