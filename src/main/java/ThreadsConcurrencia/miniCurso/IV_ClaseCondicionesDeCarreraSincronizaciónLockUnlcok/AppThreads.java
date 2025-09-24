package ThreadsConcurrencia.miniCurso.IV_ClaseCondicionesDeCarreraSincronizaciónLockUnlcok;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class AppThreads {

    public static void main(String[] args) {
        // Crear una instancia de la clase LockAndUnlock que contiene la lista y los métodos para modificarla
        final LockAndUnlock lockAndUnlock = new LockAndUnlock();

        // Crear dos hilos que intenten acceder a la misma lista al mismo tiempo
        new Thread(() -> lockAndUnlock.insert(Thread.currentThread())).start();
        new Thread(() -> lockAndUnlock.insert(Thread.currentThread())).start();
    }
}

class LockAndUnlock {

    private ArrayList<Integer> list = new ArrayList<>();
    // Crear un Lock para sincronizar el acceso a la lista
    private Lock lock = new ReentrantLock(); // <<--- Lock compartido por todos los hilos

    public void insert(Thread thread) {

        // bloquearemos la lista empezando a ser esta modificada, y una vez terminada la modificación se desbloqueará
        try {
            lock.lock(); // bloquea el acceso a la lista para otros hilos, hasta que se llame a unlock()
            System.out.println(thread.getName() + " Locking");

            Thread.sleep(2000); // simula trabajo pesado

            var range = IntStream.range(0, 1000);
            range.forEach(i -> list.add(i));

            System.out.println(thread.getName() + " terminó de insertar " + list.size() + " elementos");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock(); // libera el acceso a la lista para otros hilos
            System.out.println(thread.getName() + " Unlocking");
        }
    }
}
