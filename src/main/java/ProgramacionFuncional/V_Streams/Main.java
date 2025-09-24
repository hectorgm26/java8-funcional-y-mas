package ProgramacionFuncional.V_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Los Streams en Java son una forma de trabajar colecciones de manera funcional y eficiente
// Aplican en Optionals ya que pese a no ser colecciones, son "contenedores" que puede tener 0 o 1 de valor.
// En lugar de iterar manualmente sobre elementos de una coleccion,
// se usan Streams para realizar operaciones como filttado, transformacion y reduccion de manera declarativa y concisa
// Los stram se pueden crearse de colecciones Set, List, Map, etc
// Son secuencias de elementos que no almacenan datos, sino que los procesa sobre la marcha en tiempo real
// Tareas comunes con Streams: Filtrar, transformar, agrupar o reducir, opciones parelalelas y optimizadas
// Tienen termino intermedio y termino final, es decir, operaciones que se pueden anidar entre si
public class Main {
    public static void main(String[] args) {

        // ************** EJEMPLO SIN OPERACIONES INTERMEDIAS **************
        List<String> nombres = new ArrayList<>();
        nombres.add("Hector");
        nombres.add("Yanira");
        nombres.add("Javier");

        nombres.stream().forEach(System.out::println);
        // En este caso, se usa una referencia a metodo System.out::println para imprimir cada nombre en la consola, ya que el metodo println es estatico de la clase System


        // ************** EJEMPLO CON OPERACIONES INTERMEDIAS
        List<String> paises = Arrays.asList("Chile", "Argentina", "Italia", "Francia", "Colombia", "Peru", "Venezuela", "Ecuador", "Bolivia"); // el metodo asList devuelve una lista inmutable, es decir, un array fijo, ya que las listas son mutables

        // Filtrar paises que tengan en su nombre al menos una letra a
        paises.stream()
                .filter(pais -> pais.toLowerCase().contains("a"))
                .forEach(System.out::println);
    }
}

/*
Estructura:
1) Instancia de Stream en una coleccion (source, o el elemento de entrada)
2) Operaciones intermedias (filter, map, sorted) OPCIONAL
3) Operacion terminal (forEach, collect, reduce, count, sum) OBLIGATORIA, pueden hacerse incluso sin operaciones intermedias

Streams posibles:

Fuente de datos:
- Collection.stream() - Crea un stream secuencial desde una coleccion
- Collection.parallelStream() - Crea un stream paralelo desde una coleccion
- Arrays.stream(array) - Crea un stream desde un array

Operaciones intermedias:
- filter(Predicate) - Filtra elementos segun una condicion
- map(Function<T, R>) - Transforma elementos aplicando una funcion - en otras palabras, .map itera sobre todos los elementos del stream. transforma cada elemento por medio de una funcion o de un metodo de una clase
- mapToInt(Function) - Transforma elementos a int aplicando una funcion
- mapToLong(Function) - Transforma elementos a long aplicando una funcion
- mapToDouble(Function) - Transforma elementos a double aplicando una funcion
- flatMap(Function) - Transforma y aplana elementos que son colecciones
- distinct() - Elimina elementos duplicados
- sorted() - Ordena elementos en orden natural - OCUPA COMPARATOR con comparing

Operaciones terminales:
- findFirst() - Devuelve el primer elemento del stream
- findAny() - Devuelve cualquier elemento del stream
- allMatch(Predicate) - Verifica si todos los elementos cumplen una condicion
- anyMatch(Predicate) - Verifica si algun elemento cumple una condicion
- noneMatch(Predicate) - Verifica si ningun elemento cumple una condicion
- collect(Collector) - Recopila elementos en una coleccion
- toArray() - Convierte el stream en un array
- count() - Cuenta el numero de elementos en el stream
- average() - Calcula el promedio de elementos numericos
- sum() - Suma elementos numericos
- forEach(Consumer) - Itera sobre cada elemento del stream, y dentro del forEach se puede usar una referencia a metodo o una lambda
- reduce(BinaryOperator) - Reduce los elementos a un solo valor aplicando una operacion binaria
- min(Comparator) - Encuentra el elemento minimo segun un comparador
- max(Comparator) - Encuentra el elemento maximo segun un comparador
- toList() - Convierte el stream en una lista
- toSet() - Convierte el stream en un conjunto
- toMap(Function, Function) - Convierte el stream en un mapa

*/