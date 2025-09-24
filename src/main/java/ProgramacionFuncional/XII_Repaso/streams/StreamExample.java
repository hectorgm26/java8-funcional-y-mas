package ProgramacionFuncional.XII_Repaso.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Un stream es un flujo de datos en el que operamos uno por uno datos de una coleccion de forma funcional
// Cada elemento pasa por una "linea de ensamblaje" en la que se le aplican una serie de operaciones
// Un stream es un stream de algo (Stream<T>), que define el tipo de dato de los elementos que portan en su interior
// Los stream seran del tipo que se corresponda con la coleccion que los genera

// Detro de la linea de ensamblaje, las operaciones se dividen en dos tipos: intermedias y terminales
// Y pueden ser de tipo: modificar, filtrar, ordenar, agrupar, etc, es decir, lo que entra sale modificado
public class StreamExample {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ana", "Luis", "Pedro", "Maria", "Juan", "Alberto", "Ana");

        // filter() : Filtra los elementos que cumplen una condicion
        // Los que no cumplen la condicion son eliminados del Stream
        names.stream()
                .filter((name) -> name.length() > 4) // Operacion intermedia, por ende requiere de una operacion terminal
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // map() : Transforma los elementos aplicando una funcion
        names.stream()
                .map((name) -> name.toUpperCase()) // Operacion intermedia
                // como se recibe un parametro, y se usa ese mismo,
                // se puede hacer con method reference por medio de la clase del metodo con la que estoy trabajando: map(String::toUpperCase)
                .filter((name) -> name.startsWith("A"))
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // sorted() : Ordena los elementos del Stream.
        // Por defecto, ordena en orden natural (alfabetico o numerico), Y se cambia con un Comparator
        names.stream()
                .sorted()
                .forEach(System.out::println);

        names.stream()
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(Comparator.reverseOrder()))
                // Ordena por longitud y luego alfabeticamente inverso
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // forEach() : Aplica una accion a cada elemento del Stream
        // Recibe en los parametros un elemento del Stream, o varios, dependiendo de la estructura del Stream y de su coleccion
        names.stream()
                .forEach((name) -> {
                    // Podemos hacer muchas cosas dentro del forEach, no solo imprimir
                    System.out.println("Hola" + name);
                });

        System.out.println("-----------------------------------------------------------");

        /*
        reduce() : Combina todos los elementos en un solo valor,
        es decir, los concatena, o los suma/multiplica/etc
        Compacta todos los elementos del Stream a un tipo <T>, el cual no tiene que ser del mismo tipo que el Stream

        Estructura del reduce:
        reduce ( (a, b) -> c )
        a: es el valor acumulado (o el identity, si se define)
        b: es el elemento actual del Stream
        c: es el resultado de la operacion entre a y b

        En cada iteracion, b es el siguiente elemento del Stream,
        y a es el resultado de la operacion anterior,
        y c es el nuevo valor acumulado que se devuelve, la cual sera el primer parametro que entrara en a en la segunda iteracion
        */

        String result = names.stream()
                .reduce("Resultado: ", (a, b) -> {
                    return a + " " + b;
                }); // Es un operador terminal

        System.out.println(result);
        // El identity es un valor inicial, pero es opcional (se puede dejar vacio, PERO SI O SI COLOCARSE)
        // Y si no se pone, el resultado es un Optional<T>

        // ************************ 3 formas de usarlo ****************************
        List<String> paises = List.of("Colombia", "Peru", "Chile", "Argentina", "Bolivia", "Nicaragua");
        Stream<String> str = paises.stream();
        Stream<String> str2 = paises.stream();
        Stream<String> str3 = paises.stream();

        // 1. Que devuelva un tipo de dato distinto al de los elementos del stream - calcular la cantidad de letras en total de la lista de paises
        int total = str.map(String::length) // se transforman a integer
                .reduce(0, (ac, lenght) -> ac + lenght);

        // 2. Sin pasarle un valor identity inicial - devuelve un Optional<T>,
        // Se debe usar como tipo de dato un Optional con el tipo de dato que devolvera el stream
        // y se usa ifPresent para imprimir si tiene valor o no, ya que de estar vacio devuelve un empty
        // Al no pasarle un identity, simplemente coje el primer elemento del stream como valor inicial
        Optional<Integer> total2 = str2.map(String::length)
                .reduce((ac, lenght) -> ac + lenght);

        // 3. Reduce con 3 argumentos: identity, accumulator y combiner
        // El combiner se usa para combinar resultados parciales en operaciones paralelas, transformando y agrupando los resultados
        // Ejemplo: acumulaciones parciales, pero esas acumulaciones agrupandolas de alguna forma
        int total3 = str3.reduce(0, (id, s) -> id + s.length(), Integer::sum);

        System.out.println("Total de letras: " + total);
        total2.ifPresent(t -> System.out.println("Total de letras: " + t));
        System.out.println("Total de letras: " + total3);

        System.out.println("-----------------------------------------------------------");

        // collect() : Recoge todos los elementos en una coleccion (List, Set, Map, etc)
        // Recibe otra funcion llamada Collectors para definir en que coleccion se van a guardar los elementos
        List<Integer> resultado = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        // Usado mucho en versiones antiguas, ya que ahora basta con .toList() al final del stream

        resultado.stream().forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // distinc() : Elimina los elementos duplicados
        names.stream()
                .distinct() // Operacion intermedia
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // limit() : Limita el numero de elementos procesados
        names.stream()
                .limit(3) // Operacion intermedia
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // skip() : Omite un numero especifico de elementos para empezar desde otro punto
        // Se empeza a contar desde el primer elemento 0 hacia adelante, contando normalmente
        names.stream()
                .skip(2) // Operacion intermedia
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // anyMatch() : Verifica si al menos un elemento cumple con una condicion
        boolean resultadob = names.stream()
                .anyMatch((name) -> name.startsWith("A")); // Operacion terminal, devuelve un boolean

        System.out.println(resultadob);

        System.out.println("-----------------------------------------------------------");

        // allMatch() : Verifica si todos los elementos cumplen con una condicion
        boolean resultadob2 = names.stream()
                .allMatch((name) -> name.length() > 3); // Operacion terminal, devuelve un boolean

        System.out.println(resultadob2);

        System.out.println("-----------------------------------------------------------");

        // noneMatch() : Verifica si ningun elemento cumple con una condicion
        boolean resultadob3 = names.stream()
                .noneMatch((name) -> name.isEmpty()); // Operacion terminal, devuelve un boolean

        System.out.println(resultadob3);

        System.out.println("-----------------------------------------------------------");

        // count() : Cuenta el numero de elementos en el Stream
        // Devuelve un long, ya que puede ser un numero muy grande
        long count = names.stream()
                .filter((name) -> name.length() > 3) // Operacion intermedia
                .count(); // Operacion terminal, devuelve un long

        System.out.println(count);

        System.out.println("-----------------------------------------------------------");

        // findFirst() : Devuelve el primer elemento del Stream que cumple con una condicion
        names.stream()
                .filter((name) -> name.startsWith("A")) // Operacion intermedia
                .findFirst() // Operacion terminal, devuelve un Optional<T>
                .ifPresent(System.out::println); // Si el Optional tiene un valor, lo imprime

        System.out.println("-----------------------------------------------------------");

        // findAny() : Devuelve cualquier elemento del Stream que cumple con una condicion
        names.stream()
                .filter((name) -> name.startsWith("A")) // Operacion intermedia
                .findAny() // Operacion terminal, devuelve un Optional<T>
                .ifPresent(System.out::println); // Si el Optional tiene un valor, lo imprime

        System.out.println("-----------------------------------------------------------");

        // flatmap (): Transforma y aplana una estructura de datos
        // Por aplanar se refiere a convertir una estructura de datos anidada en una estructura plana
        // Se diferencia de map() en que este ultimo mantiene la estructura de datos original,
        // en cambio de flatmap() la aplana (significa que elimina un nivel de anidacion)
        // Ejemplo: de List<List<String>> a List<String>
        var frutas = List.of("Manzana", "Limon", "Mandarina");
        var variedades = List.of("Verde", "Dulce", "Premium");

        // tendremos una lista con listas dentro
        // [[Manzana Verde, Manzana Dulce, Manzana Premium], [Limon Verde, Limon Dulce, Limon Premium], [Mandarina Verde, Mandarina Dulce, Mandarina Premium]]
        var strings = frutas.stream()
                .map((fruta) -> {
                    return variedades.stream()
                            .map((variedad) -> fruta + " " + variedad)
                            .collect(Collectors.toList());
                })
                .collect(Collectors.toList());

        // Con flatmap se aplana la estructura, quedando una sola lista con todos los elementos
        var strings2 = frutas.stream()
                .flatMap((fruta) -> {
                    return variedades.stream()
                            .map((variedad) -> fruta + " " + variedad);
                })
                .collect(Collectors.toList());

        System.out.println(strings);
        System.out.println(strings2);

        strings.stream()
                .flatMap(List::stream) // Aplanamos la estructura para imprimir cada elemento
                .forEach(System.out::println);


        // Otro ejemplo
        List<Integer> lista1 = Arrays.asList(1, 2, 3);
        List<Integer> lista2 = Arrays.asList(4, 5, 6);
        List<Integer> lista3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listasAnidadas = Arrays.asList(lista1, lista2, lista3);

        List<Integer> listaFinal = listasAnidadas.stream()
                .flatMap((lista) -> lista.stream()) // Aplanamos la estructura, lo mismo que List::stream
                .collect(Collectors.toList());

        System.out.println(listaFinal);

        System.out.println("-----------------------------------------------------------");

        // min() : Devuelve el elemento minimo segun un Comparator
        names.stream()
                .min(Comparator.comparing(String::length)) // Operacion terminal, devuelve un Optional<T>
                .ifPresent(System.out::println); // Si el Optional tiene un valor, lo imprime

        System.out.println("-----------------------------------------------------------");

        // max() : Devuelve el elemento maximo segun un Comparator
        names.stream()
                .max(Comparator.comparing(String::length)) // Operacion terminal, devuelve un Optional<T>
                .ifPresent(System.out::println); // Si el Optional tiene un valor, lo imprime

        /*
        Para obtener el max de un Map y su key
        map.entrySet().stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .map(Map.Entry::getKey).ifPresent(System.out::println);  //se mapea al nombre de la categoria que tiene el precio promedio mas alto

        // entry es un par (clave, valor), y Map.Entry es la interfaz que representa ese par
        // por getValue se obtiene el valor (promedio), y por getKey la clave (categoria)
        */

        System.out.println("-----------------------------------------------------------");

        // IntStream, LongStream, DoubleStream: Son streams especializados para tipos primitivos
        // se pueden usar con range() y rangeClosed() para generar secuencias de numeros como bucles for
        IntStream range = IntStream.range(1, 10); // 1 a 9 (10 no incluido)
        IntStream rangeClosed = IntStream.rangeClosed(1, 10); // 1 a 10 (10 incluido)

        range.forEach(System.out::println);
        rangeClosed.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // Collectors.groupingBy() : Agrupa los elementos segun una clave
        /*
        var productos = List.of(
                new Producto("Manzana", "frutas", 1, 2.5),
                new Producto("Banana", "frutas", 2, 1.5),
                new Producto("Lechuga", "verduras", 1, 3.0),
                new Producto("Zanahoria", "verduras", 3, 2.0),
                new Producto("Pollo", "carnes", 1, 10.0),
                new Producto("Carne de res", "carnes", 2, 15.0),
                new Producto("Pescado", "carnes", 1, 12.0),
                new Producto("Yogur", "lacteos", 5, 1.0),
                new Producto("Queso", "lacteos", 2, 5.0),
                new Producto("Leche", "lacteos", 3, 2.0)
        );

        Map<String, List<Producto>> productosAgrupados = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));

       // Esto lo que hara es agrupar los productos por categoria, devolviendo un Map
       // donde la clave es la categoria, y el valor es una lista de productos de esa categoria

        productosAgrupados.forEach((categoria, lista) -> {
            System.out.println(" - " + categoria + ": " + lista);

        Y PARA HACERLE UN STREAM AL MAP:
            productosAgrupados.entrySet().stream() → stream de pares (categoria, listaDeProductos)
            productosAgrupados.keySet().stream() → stream de las claves (String categorías)
            productosAgrupados.values().stream() → stream de las listas de productos

         */

        System.out.println("-----------------------------------------------------------");

        // Promedios: Collectors.averagingDouble() o averagingInt()
        /*
        Con averagingDouble se puede calcular el promedio de una propiedad numerica de los objetos en el stream
        Ejemplo: promedio de precios de productos

        double promedioPrecios = productos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));
         */
    }
}
