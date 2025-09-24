package ProgramacionFuncional.XII_Repaso.lambdas.callable;

import java.util.concurrent.Callable;

public class CallableExample {
    public static void main(String[] args) {

        /*
        Callable:
        No recibe valores, pero retorna un resultado y puede lanzar una excepción.
         */
        Callable<String> callable = () -> {
            return "Resultado de la tarea";
        };

        // para ejecutar el callable se utiliza el método call() dentro de un bloque try-catch
        try {
            String result = callable.call();
            System.out.println(result);

        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            System.out.println("Tarea finalizada");
        }

    }
}
