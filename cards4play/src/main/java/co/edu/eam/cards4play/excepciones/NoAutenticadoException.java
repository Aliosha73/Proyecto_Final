package co.edu.eam.cards4play.excepciones;

/** HTTP 401 */
public class NoAutenticadoException extends ApiException {
    public NoAutenticadoException(String mensaje) {
        super(401, mensaje);
    }
}
