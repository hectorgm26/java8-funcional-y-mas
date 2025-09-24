package ThreadsConcurrencia.miniCurso.II_ClasePoolThreadsCallbacks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

// Executors: Nos permite crear hilos de manera mas sencilla y rapida
// Nos permite crear un pool de hilos y reutilizarlos
public class AppThreads {

    public static void main(String[] args) {

        var sessionFactory = new CreateSession();

        var executor = Executors.newFixedThreadPool(20); // Creamos un pool de 20 hilos
        IntStream range = IntStream.range(0, 100);

        // el i sera el iterador del stream que sera el indice del for
        range.forEach(i -> {

            // objeto envoltorio future que contiene el objeto Session, y por el metodo get obtenemos el objeto Session
            var session = executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                return sessionFactory.create("User-" + i); // se retorna un objeto de tipo Session
            });

            try {
                System.out.println(session.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown(); // Cerramos el pool de hilos

    }
}

class CreateSession {

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
