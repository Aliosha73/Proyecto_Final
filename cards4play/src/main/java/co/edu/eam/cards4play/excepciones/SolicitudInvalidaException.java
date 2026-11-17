package co.edu.eam.cards4play.excepciones;

/** HTTP 400 */
public class SolicitudInvalidaException extends ApiException {
    public SolicitudInvalidaException(String mensaje) {
        super(400, mensaje);
    }
}
