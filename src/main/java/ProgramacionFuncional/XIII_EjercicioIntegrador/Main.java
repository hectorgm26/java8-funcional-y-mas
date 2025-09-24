package ProgramacionFuncional.XIII_EjercicioIntegrador;

import ProgramacionFuncional.XIII_EjercicioIntegrador.logica.Producto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Lista de productos
        List<Producto> productos = Arrays.asList(
                new Producto("Manzana", "frutas", 1, 2.5),
                new Producto("Banana", "frutas", 2, 1.5),
                new Producto("Lechuga", "verduras", 1, 3.0),
                new Producto("Zanahoria", "verduras", 3, 2.0),
                new Producto("Pollo", "carnes", 1, 10.0),
                new Producto("Carne de res", "carnes", 2, 15.0),
                new Producto("Pescado", "carnes", 1, 12.0),
                new Producto("Yogur", "lacteos", 5, 1.0),
                new Producto("Queso", "lacteos", 2, 5.0),
                new Producto("Leche", "lacteos", 3, 2.0),
                new Producto("Pan", "panaderia", 4, 1.5),
                new Producto("Croissant", "panaderia", 2, 2.0),
                new Producto("Muffin", "panaderia", 3, 2.5),
                new Producto("Pera", "frutas", 2, 3.0),
                new Producto("Espinaca", "verduras", 1, 4.0),
                new Producto("Cerdo", "carnes", 1, 14.0),
                new Producto("Helado", "lacteos", 2, 6.0)
        );

        // 1. filtrar productos de la categoria frutas
        List<Producto> frutas = productos.stream()
                .filter((producto) -> producto.getCategoria().equalsIgnoreCase("frutas"))
                .collect(Collectors.toList());

        System.out.println("\n 1. Productos que son frutas: " + frutas);


        // 2. Calcular el precio total de los productos en "lacteos"
        double totalLacteos = productos.stream()
                .filter((producto) -> producto.getCategoria().equalsIgnoreCase("lacteos"))
                .map(Producto::getPrecio) // se debe transformar el stream de productos a un stream de precios
                .reduce(0.0, (acc, precio) -> acc + precio);

        /*
        Se podia tambien usar .mapToDouble(Producto::getPrecio) y luego .sum() en lugar de reduce
         */

        System.out.println("\n 2. Precio total de los productos en lacteos: " + totalLacteos);


        // 3. Obtener el producto con el precio mas bajo
        Optional<Producto> productoMasBarato = productos.stream()
                .min(Comparator.comparingDouble(Producto::getPrecio));

        /*
        Se podia agregar luego del min un orElse para evitar el uso de Optional,
        y se pone para devolver un valor por defecto en caso de que la lista este vacia,
        o null (pero si es null puede dar error despues al querer usar el objeto)
         */
        productoMasBarato.ifPresent(producto -> System.out.println("\n 3. El producto mas barato es: " + producto));


        // 4. Agrupar productos por categoria
        Map<String, List<Producto>> productosPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));

        // Esto lo que hara es agrupar los productos por categoria, devolviendo un Map
        // donde la clave es la categoria, y el valor es una lista de productos de esa categoria

        System.out.println("\n 4. Productos agrupados por categoria:");
        productosPorCategoria.forEach((categoria, lista) -> {
            System.out.println(" - " + categoria + ": " + lista);
        });


        // 5. Calcular el precio promedio de los productos por categoria
        Map<String, Double> promedioPorCategoria = productos.parallelStream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio) // de cada producto de una categoria recolecta el precio y saca el promedio
                ));

        System.out.println("\n 5. El precio promedio por categoria es: " + promedioPorCategoria);

        // 6. Obtener la categoria con el precio promedio mas alto
        /*
        PARA HACERLE UN STREAM AL MAP:
            productosAgrupados.entrySet().stream() → stream de pares (categoria, listaDeProductos)
            productosAgrupados.keySet().stream() → stream de las claves (String categorías)
            productosAgrupados.values().stream() → stream de las listas de productos
         */

        Optional<String> categoriaMasCara = promedioPorCategoria.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey); // se mapea al nombre de la categoria que tiene el precio promedio mas alto

        // entry es un par (clave, valor), y Map.Entry es la interfaz que representa ese par
        // por getValue se obtiene el valor (promedio), y por getKey la clave (categoria)

        categoriaMasCara.ifPresent(categoria -> System.out.println("\n 6. La categoria con el precio promedio mas alto es: " + categoria));
    }
}
