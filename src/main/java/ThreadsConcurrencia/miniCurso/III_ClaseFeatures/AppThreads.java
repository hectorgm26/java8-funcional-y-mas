package ThreadsConcurrencia.miniCurso.III_ClaseFeatures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// CompletableFuture es una clase que permite trabajar con hilos de manera asincrona
// Sin necesidad de crear un pool de hilos
public class AppThreads {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Supplier es una intefaz funcional que se encarga de crear una instancia de un objeto a partir de un metodo
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Subscribete");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Debuguendo Ideas");

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName();
        });

        // levantar/correr los 3 hilos de forma paralela sin un pulll de hilos, mediante el metodo allOf
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get(); // Esperar a que todos los hilos se ejecuten simultaneamente

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}

/*
La interdaz future es una interfaz que representa el resultado de una computación asincrona
Sintaxis:
Future<V> future = executorService.submit(callable);

El metodo submit recibe un callable que es una interfaz funcional que representa una tarea que devuelve un valor

Uso:
ExecutorService executorService = Executors.newFixedThreadPool(10);
Future<String> future = executorService.submit(() -> {
    // tarea que devuelve un valor
    return "resultado";
});

String result = future.get(); // Bloquea el hilo hasta que la tarea se complete y devuelve el resultado

 */
