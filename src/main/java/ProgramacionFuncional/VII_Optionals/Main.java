package ProgramacionFuncional.VII_Optionals;

import java.util.Optional;

// Los optionals son una clase especial de Java que se introdujo en Java 8 para manejar valores que pueden estar ausentes o nulos de manera segura y elegante
// Proporciona una forma segura de trabajar con posibles valores nulos, evitando NullPointerException y mejorando la legibilidad del codigo
public class Main {
    public static void main(String[] args) {

        // ********** Ejemplo 1 **********
        // Puedo recibir como resultado o un string o un optional (es decir o un null o vacio)
        Optional<String> stringNull = Optional.ofNullable(null);
        // Como viene un valor null, cuando se recibe el null, en lugar de tomar ese valor,
        // se transforma en un objeto vacio, evitando lanzar una excepcion

        if (stringNull.isEmpty()) {
            System.out.println("El valor es vacio");
        }

        if (stringNull == null) {
            System.out.println("El valor: " + stringNull.get() + " es nulo");
        }


        // ********** Ejemplo 2 **********
        Optional<String> cadena = Optional.of("Hola Mundo");
        // Como el .of no permite valores nulos, si se le pasa un valor nulo, lanza NullPointerException

        if (cadena.isEmpty()) {
            System.out.println("El valor es vacio");
        } else {
            System.out.println("La cadena tiene valor, y es: " + cadena.get());
        }


        // ********** Ejemplo 3 **********
        Optional<String> cadena2 = Optional.empty();
        // Si quiero devolver un vacio de un optional se usa el metodo empty()

        if (cadena2.isEmpty()) {
            System.out.println("El valor es vacio");
        } else {
            System.out.println("La cadena tiene valor");
        }

        // Verificar el tipo de dato que se devuelve
        System.out.println("El tipo de cadena2 es: " + cadena2.getClass().getName());
    }
}


/*
DIFERENCIA ENTRE VALORES NULOS Y VACIOS - Ejemplo una caja
- Nulo (null): indica que no existe una caja, es decir, no hay nada en absoluto. Intentar acceder a un valor nulo provoca una excepcion NullPointerException en Java. Por ejemplo, una variable que no ha sido inicializada o que se le ha asignado el valor null es una variable nula.
- Vacio: indica que existe una caja, pero no contiene nada dentro. Por ejemplo, una cadena vacia ("") es una cadena que existe pero no tiene caracteres. Una lista vacia es una lista que existe pero no contiene elementos. Los valores vacios son validos y no provocan excepciones al acceder a ellos.

Los metodos de Opcionals hacen referencia a valores vacios, no a valores nulos


3 Metodos estaticos:
- empty(): Crea un Optional vacio, es decir, sin valor
- off(T value): Crea un Optional con un valor en particular (lanza excepcion si el valor es nulo)
- offNullable(T value): Crea un Optional que estara vacio si el valor que recibees null, o puede recibir un valor como tal
Si el valor es nulo, devuelve un Optional vacio; de lo contrario,
devuelve un Optional que contiene el valor que se le pasa como argumento

Metodos de instancia:
- isPresent(): Devuelve true si el Optional contiene un valor, false si esta vacio
- isEmpty(): Devuelve true si el Optional esta vacio, false si contiene un valor
- get(): Devuelve el valor contenido en el Optional si esta presente; lanza NoSuchElementException si esta vacio
- orElse(T other): Devuelve el valor contenido en el Optional si esta presente; de lo contrario, devuelve el valor proporcionado como argumento
- orElseGet(Supplier<? extends T> other): Devuelve el valor contenido en el Optional si esta presente; de lo contrario, ejecuta la funcion proporcionada y devuelve su resultado
- orElseThrow(): Devuelve el valor contenido en el Optional si esta presente; de lo contrario, lanza NoSuchElementException


COMO APLICA EL .MAP DE STREAM

Un Optional<T> no es una colección, pero sí un "contenedor" que puede tener 0 o 1 valor.
La clase Optional también tiene un método .map(Function<? super T,? extends U>).

La idea es:
Si el Optional está vacío → no hace nada.
Si el Optional tiene valor → aplica la función y devuelve un nuevo Optional.

Ejemplo:
Optional<Cliente> optionalCliente = obtenerCliente(); // puede estar vacío o no
Optional<String> optionalNombre = optionalCliente.map(Cliente::getNombre);

Aquí:
Si optionalCliente no tiene cliente → optionalNombre queda vacío.
Si sí hay cliente → se aplica getNombre() y optionalNombre contiene el String.

Optional.map: transforma el único valor si existe.
*/