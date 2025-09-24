package ProgramacionFuncional.X_StreamCollectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Los collectors son una herramienta de la API Streams de Java que permiten recolectar los resultados
// de un stream en una operacion final, como una lista, un conjunto, un mapa, o incluso un solo valor (promedio, suma, etc).
public class Main {
    public static void main(String[] args) {

        // Collectors.toList(): Recolecta los elementos del stream en una lista.
        List<String> nombres = List.of("Ana", "Luis", "Carlos", "Marta", "Lucia");
        // la diferencia entre List.of y Arrays.asList es que List.of crea una lista inmutable,
        // mientras que Arrays.asList crea una lista mutable, solo pudiendo modificar los elementos existentes, mas no añadir o eliminar.

        List<String> nombresConA = nombres.stream()
                .filter(nombre -> nombre.contains("a"))
                .collect(Collectors.toList());

        System.out.println(nombresConA);


        // Collectors.toSet(): Recolecta los elementos del stream en un conjunto (set), eliminando duplicados.
        List<String> lenguajes = List.of("java", "python", "javaScript", "c#", "java", "python");

        Set<String> lenguajesUnicosConMayuscula = lenguajes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        System.out.println(lenguajesUnicosConMayuscula);


        // Collectors.joining(): Concatena los elementos del stream en una sola cadena, con un separador opcional, eligiendo de que forma se unen y separan
        List<String> dbs = List.of("MySQL", "PostgreSQL", "SQL Server", "SQLite");

        String listaTecnologias = dbs.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" | "));

        System.out.println(listaTecnologias);


        // Collectors.counting(): Cuenta el número de elementos en el stream.
        List<String> paises = List.of("Argentina", "Brasil", "Chile", "Colombia", "Ecuador", "Australia", "Alemania");

        Long numeroPaises = paises.stream()
                .filter(pais -> pais.startsWith("A"))
                .collect(Collectors.counting()); // El collector devuelve un long y no un int, porque desconocemos la cantidad de valores que puede haber

        System.out.println("Número de países que empiezan con A: " + numeroPaises);


        // Collectors.partitioningBy(): Divide los elementos del stream en dos grupos según un predicado (true/false).
        List<Integer> edades = List.of(15, 22, 18, 30, 12, 25, 17, 40, 8, 6, 2, 60);

        // El map pide dos parametros, una clave y un valor
        // La clave sera un booleano (true o false) y el valor sera una lista de enteros
        Map<Boolean, List<Integer>> mayores = edades.stream()
                .collect(Collectors.partitioningBy(edad -> edad >= 18));
        // Los que sean mayores a 18 seran los VERDADEROS, y los que no, FALSOS

        System.out.println(mayores);
        // Para acceder a los valores del mapa, usamos el metodo get y le pasamos la clave
        System.out.println("Mayores de edad: " + mayores.get(true));
        System.out.println("Menores de edad: " + mayores.get(false));


        // Collectors.averagingInt(), Collectors.averagingDouble(), Collectors.averagingLong(): Calcula el promedio de los elementos del stream.
        List<Integer> numeros = List.of(10, 20, 30, 40, 50);

        Double pronedio = numeros.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        // El collector pide una funcion que convierta el elemento del stream en un int, double o long, segun corresponda

        System.out.println("Promedio: " + pronedio);


        // Collectors.summingInt(), Collectors.summingDouble(), Collectors.summingLong(): Calcula la suma de los elementos del stream.
        Integer suma = numeros.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Suma: " + suma);
    }
}
