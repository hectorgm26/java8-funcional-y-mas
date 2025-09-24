package ThreadsConcurrencia.miniCurso.II_ClasePoolThreadsCallbacks;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

// Aplicando la interfaz runnable si no quisieramos regresar ningun objeto
public class AppThreads2 {

    public static void main(String[] args) {

        var sessionFactory = new CreateSession();

        var executor = Executors.newFixedThreadPool(20);
        IntStream range = IntStream.range(0, 100);

        range.forEach(i -> {

            // implementamos la interfaz runnable
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });

        });
        executor.shutdown();

    }
}

class CreateSession2 {

    public Session create(String username) {
        try {
            Thread.sleep(1000L); // Simular crear un trabajo pesado como una consulta a BD ya que lleva tiempo.
            // Simulara un segundo cada vez que se cree una sesion
            return new Session(username);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
