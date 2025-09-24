package ThreadsConcurrencia.logica;

// Hay dos formas de crear hilos en Java:
// 1. Extender la clase Thread
// 2. Implementar la interfaz Runnable

public class HiloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hilo ejecutandose con interfaz Runnable");
    }

    // Como no tiene el metodo start, debemos desde Runnable indicar un Hilo Thread que se cree para poder hacer ejecucion
    // En el main, se debe hacer Thread proceso = new Thread(new HiloRunnable());
    // De esta forma se crea un objeto de tipo Thread que recibe como parametro una instancia de HiloRunnable creado, y asi poder llamar al metodo start(
    // En simple, creamos el runnable a traves de un hilo
}
