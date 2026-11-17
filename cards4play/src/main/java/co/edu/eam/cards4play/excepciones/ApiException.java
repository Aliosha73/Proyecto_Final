package co.edu.eam.cards4play.excepciones;

/** Error de negocio con el código HTTP que debe devolver la API. */
public class ApiException extends RuntimeException {
    private final int codigoHttp;

    public ApiException(int codigoHttp, String mensaje) {
        super(mensaje);
        this.codigoHttp = codigoHttp;
    }

    public int getCodigoHttp() {
        return codigoHttp;
    }
}
