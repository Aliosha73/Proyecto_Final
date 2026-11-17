package co.edu.eam.cards4play.excepciones;

/** HTTP 409 */
public class ConflictoException extends ApiException {
    public ConflictoException(String mensaje) {
        super(409, mensaje);
    }
}
