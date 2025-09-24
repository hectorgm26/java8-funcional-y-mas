package Enums;

// Dentro de ponen los valores concretos que puede adoptar el Enum
// Se comportaran como constantes, es decir, no cambian de valor
public enum PuntoCardinal {
    NORTE('N'),
    SUR('S'),
    ESTE('E'),
    OESTE('O');

    public char sigla;

    // A un enum se le pueden añadir atributos y metodos, es decir constructores
    PuntoCardinal(char sigla) {
        this.sigla = sigla;
    }

    public char getSigla() {
        return sigla;
    }

    public PuntoCardinal girarHorario() {
        switch (this) {
            case NORTE:
                return ESTE;
            case ESTE:
                return SUR;
            case SUR:
                return OESTE;
            case OESTE:
                return NORTE;
            default:
                throw new IllegalStateException("Dirección desconocida: " + this);
        }
    }

    // LOS enums tiene metodos estaticos propios de la clase Enum
    // values() -> devuelve un array con todos los valores del enum
    // valueOf(String name) -> devuelve el valor del enum que coincide con el nombre pasado como parametro
    // ordinal() -> devuelve la posicion del valor del enum en la lista (empieza en 0)
    // name() -> devuelve el nombre del valor del enum (igual que toString()
    // compareTo(E o) -> compara el valor del enum con otro valor del mismo enum (devuelve un int)
    // equals(Object o) -> compara el valor del enum con otro valor del mismo enum (devuelve un boolean)

}
