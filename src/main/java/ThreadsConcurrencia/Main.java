package ThreadsConcurrencia;

import ThreadsConcurrencia.logica.Hilo;
import ThreadsConcurrencia.logica.HiloRunnable;

public class Main {
    public static void main(String[] args) {

        // Crear instancia del hilo extendiendo Thread
        Hilo proceso = new Hilo();
        proceso.start(); // start es un metodo propio de la clase Thread que inicia la ejecucion del hilo y llama al metodo run()


        // Crear hilo implementando Runnable
        Thread proceso2 = new Thread(new HiloRunnable());
        proceso2.start();

        // DIFERENCIAS
        // La principal diferencia viene del concepto de herencia, ya que en Java no existe la herencia multiple, pero si una clase puede implementar multiples interfaces
        // Por ende, si ocupamos Thread tenemos todos los metodos de Thread, pero no podemos extender otra clase, ni utilizar metodos de otra clase al ser la misma clase un hilo
        // Por ende Runnable al no ser un hilo y solo implementar la interfaz, podemos extender otra clase y utilizar sus metodos, pero no tenemos los metodos de Thread, permitiendo una mejor reutilizacion de codigo
    }
}

/*
La concurrencia se refiere a la capacidad de un sistema o programa para realizar multiples tareas al mismo tiempo de manera aparentemente simultánea. En programación, esto se logra mediante el uso de hilos (threads) o procesos que pueden ejecutarse de manera independiente y compartir recursos del sistema.

La concurrencia implica que multiples hilos de ejecucion o procesos estan en funcionamiento al mismo tiempo y realizando sus tareas de manera independiente o concurrente

En java la forma de implementar la concurrencia es a traves de HILOS por medio de la clase Thread y la interfaz Runnable. Un hilo es una unidad de ejecucion dentro de un proceso que puede ejecutarse de manera independiente y compartir recursos del sistema con otros hilos.

Un hilo en Java, conocido como "thread" es una unidad basica de ejecucion que permite que un programa realice multiples tareas de manera concurrente

Los hilos permiten la ejecucion de varias partes de un programa al mismo tiempo, en forma de subprocesos sin que uno interfiera con el otro.

Los hilos tienen un ciclo de vida con ciertas posibilidades:
- Nuevo (New): El hilo ha sido creado pero no ha comenzado a ejecutarse.
- En ejecucion (Runnable): El hilo esta listo para ejecutarse y esperando a ser asignado a un procesador.
- En ejecucion (Running): El hilo esta siendo ejecutado por el procesador.
- Bloqueado (Blocked): El hilo esta esperando a que un recurso este disponible o a que se complete una operacion.
- Terminado (Terminated): El hilo ha completado su ejecucion o ha sido detenido.
- En espera (Waiting): El hilo esta esperando a que otro hilo le notifique para continuar su ejecucion.
- En espera con tiempo (Timed Waiting): El hilo esta esperando por un periodo de tiempo especifico antes de continuar su ejecucion.
- Muerto (Dead): El hilo ha finalizado su ejecucion y no puede ser reiniciado.
- Suspendido (Suspended): El hilo ha sido temporalmente detenido y puede ser reanudado posteriormente.
- Resumido (Resumed): El hilo que estaba suspendido ha sido reanudado y puede continuar su ejecucion.
- Interrumpido (Interrupted): El hilo ha sido interrumpido por otro hilo, lo que puede causar que termine su ejecucion o cambie su estado.
- Prioridad (Priority): Los hilos pueden tener diferentes niveles de prioridad, lo que puede influir en el orden en que son ejecutados por el planificador del sistema operativo.

 */