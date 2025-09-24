package ThreadsConcurrencia.miniCurso.I_ClaseThreadInterfaceRunnable;

import java.util.stream.IntStream;

// A diferencia de Threads, no es necesario crear una clase que extienda de Thread,
// sino que se puede usar/implementar directamente la interfaz funcional Runnable
// pasandole la intefaz al constructor del Thread
public class AppThreads2 {

    public static void main(String[] args) {

        IntStream range = IntStream.range(0, 100);

        System.out.println("Start with thread: " + Thread.currentThread().getName());

        range.forEach(i -> {

            // Interfaz funcional Runnable, que al ser estatica, no necesita instanciarse, y puede ser usada mediante una expresion lambda
            Runnable myRun = () -> {
                System.out.println("Run in thread: " + Thread.currentThread().getName());
            };
            new SessionService().startSession("user-" + i);

            Thread myThread = new Thread(myRun, "MyThread-" + i); // Pide por parametros la interfaz Runnable y el nombre del hilo
            myThread.start(); // Iniciar el hilo creandolo
        });
    }
}
