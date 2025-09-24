package ProgramacionFuncional.XII_Repaso.lambdas.runnable;

public class RunnableExample {
    public static void main(String[] args) {

        /*
        Runnable:
        No recibe parámetros y no devuelve ningún valor, solamente ejecuta una tarea o bloque de codigo
         */
        Runnable runnable = () -> {
            System.out.println("Ejecutando tarea....");
        };

        runnable.run(); // con el método run() ejecutamos la tarea definida en la expresión lambda
    }
}
