package co.edu.eam.cards4play.modelo;

import java.util.Random;

/**
 * Rarezas de las cartas, de la más común a la más rara.
 * Las probabilidades (en %) están definidas solo aquí y suman 100.
 */
public enum Rareza {
    N("N", "Normal", 50),
    UC("UC", "Poco común", 25),
    R("R", "Raro", 15),
    SR("SR", "Súper raro", 7),
    UR("UR", "Ultra raro", 3);

    private final String codigo;
    private final String nombre;
    private final int probabilidad;

    Rareza(String codigo, String nombre, int probabilidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.probabilidad = probabilidad;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getProbabilidad() { return probabilidad; }

    /** Rareza inmediatamente más común, o null si esta ya es la más común. */
    public Rareza inferior() {
        return ordinal() == 0 ? null : values()[ordinal() - 1];
    }

    /** Rareza inmediatamente más rara, o null si esta ya es la más rara. */
    public Rareza superior() {
        return ordinal() == values().length - 1 ? null : values()[ordinal() + 1];
    }

    public static int sumaProbabilidades() {
        int suma = 0;
        for (Rareza r : values()) {
            suma += r.probabilidad;
        }
        return suma;
    }

    /** Sortea una rareza respetando las probabilidades. */
    public static Rareza sortear(Random random) {
        int numero = random.nextInt(sumaProbabilidades());
        int acumulado = 0;
        for (Rareza r : values()) {
            acumulado += r.probabilidad;
            if (numero < acumulado) {
                return r;
            }
        }
        return N; // no debería ocurrir
    }

    public static Rareza desdeCodigo(String texto) {
        for (Rareza r : values()) {
            if (r.codigo.equalsIgnoreCase(texto)) {
                return r;
            }
        }
        return null;
    }
}
