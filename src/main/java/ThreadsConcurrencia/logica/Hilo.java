package ThreadsConcurrencia.logica;

// Hay dos formas de crear hilos en Java:
// 1. Extender la clase Thread
// 2. Implementar la interfaz Runnable

public class Hilo extends Thread {

    // Una vez extendido Thread, se debe sobreescribir el metodo run(), ya que debemos crear el metodo que se ejecute cuando ejecutemos el hilo
    public void run() {
        System.out.println("Hilo ejecutandose con clase Thread");
    }
}
