package ThreadsConcurrencia.miniCurso.I_ClaseThreadInterfaceRunnable;

import java.util.stream.IntStream;

public class AppThreads {

    public static void main(String[] args) {

        // Un IntStream es una secuencia de elementos primitivos int,
        // que permite realizar operaciones funcionales sobre ellos, como un forEach, map, filter, etc.
        IntStream range = IntStream.range(0, 100);
        // Se crea un rango de 0 a 100, es decir en total 100 hilos,
        // ya que el rango es exclusivo, es decir, no incluye el 100, se resta 1 al final

        System.out.println("Start with thread: " + Thread.currentThread().getName());

        range.forEach(i -> {
            SessionThread sessionThread = new SessionThread(
                    "MyThread-" + i, // Nombre del hilo
                    "user-" + i); // Nombre de usuario

            sessionThread.start(); // Iniciar el hilo creandolo
        });
    }
}
