package ProgramacionFuncional.XII_Repaso.lambdas.consumer;

import java.util.function.Consumer;

/*
Aquí, <String> es el tipo de dato que recibe el consumer, no lo que devuelve.
La “devuelta” es void, no hay <T> para el retorno.
Equivalente a:
public void aceptar(String param) {
    System.out.println(param);
}
 */
public class ConsumerExample {
    public static void main(String[] args) {

        /*
        Consumer:
        Recibe un valor y no retorna nada
        */
        Consumer<String> consumer = (param) -> System.out.println(param);
        // Consumer<String> consumer = System.out::println;
        // Se puede hacer referencia a metodo, posible cuando solo hay un parametro y se usa directamente, no en concatenacion.

        consumer.accept("Hector"); // con accept se ejecuta el consumer
    }
}

/*
💡 Regla clave:
En Supplier<T>: <T> = retorno.
En Consumer<T>: <T> = entrada.

Por eso confunde: en métodos normales, el tipo al inicio indica retorno,
y aquí solo algunas interfaces funcionales siguen esa lógica (Supplier y Function),
mientras que otras (Consumer, Predicate) usan <T> para los parámetros.
 */
