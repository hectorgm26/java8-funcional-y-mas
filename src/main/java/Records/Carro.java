package Records;

import java.util.ArrayList;
import java.util.List;

public record Carro(List<Producto> productos) {

    public Carro() {
        this(new ArrayList<>()); // Por defecto inicializamos la lista de productos vacia
    }

    public int cantidad() {
        return productos.size();
    }

    public int precio() {
        return productos.stream()
                .mapToInt(Producto::precio)
                .sum();
    }
}
