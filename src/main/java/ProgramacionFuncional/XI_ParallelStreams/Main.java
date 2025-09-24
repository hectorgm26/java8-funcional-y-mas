package ProgramacionFuncional.XI_ParallelStreams;

import java.util.Arrays;

// Los parallel streams permiten procesar datos en paralelo, aprovechando múltiples núcleos de CPU para mejorar el rendimiento en operaciones intensivas en datos.
// En lugar de procesar cada elemento de un stream de forma individual y secuencial, los parallel streams dividen el trabajo en múltiples sub-tareas que se ejecutan simultáneamente en diferentes hilos.
// Para esto se usan hilos de procesamiento en segundo plano, lo que puede acelerar significativamente las operaciones en grandes conjuntos de datos.
// EL PROBLEMA DE LOS PARALLEL STREAMS ES QUE NO GARANTIZAN EL ORDEN DE LOS ELEMENTOS PROCESADOS, POR LO QUE NO SON ADECUADOS PARA TODAS LAS SITUACIONES.
public class Main {
    public static void main(String[] args) {

        // Procesar con Streams normales secuenciales
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Medir el tiempo de procesamiento
        Long tiempoInicio = System.nanoTime();
        Arrays.stream(numeros)
                .forEach(num -> System.out.println("Número: " + num));
        Long tiempoFin = System.nanoTime();
        System.out.println("Tiempo de procesamiento secuencial: " + (tiempoFin - tiempoInicio) + " nanosegundos");


        // Procesar con Parallel Streams
        Long tiempoInicio2 = System.nanoTime();
        Arrays.stream(numeros)
                .parallel() // Convertir el stream a paralelo, que divide el trabajo en múltiples hilos
                .forEach(num -> System.out.println("Número: " + num));
        Long tiempoFin2 = System.nanoTime();
        System.out.println("Tiempo de procesamiento paralelo: " + (tiempoFin2 - tiempoInicio2) + " nanosegundos");
    }
}
