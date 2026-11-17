package co.edu.eam.cards4play.modelo;

/** Tasa USD a COP y de dónde se obtuvo (API o valor por defecto). */
public class TasaCambio {
    private final double valor;
    private final FuenteTasa fuente;

    public TasaCambio(double valor, FuenteTasa fuente) {
        this.valor = valor;
        this.fuente = fuente;
    }

    public double getValor() { return valor; }
    public FuenteTasa getFuente() { return fuente; }
}
