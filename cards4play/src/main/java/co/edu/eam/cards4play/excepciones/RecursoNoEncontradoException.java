package co.edu.eam.cards4play.excepciones;

/** HTTP 404 */
public class RecursoNoEncontradoException extends ApiException {
    public RecursoNoEncontradoException(String mensaje) {
        super(404, mensaje);
    }
}
