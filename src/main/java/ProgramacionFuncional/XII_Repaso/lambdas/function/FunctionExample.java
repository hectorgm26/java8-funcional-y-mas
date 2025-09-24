package ProgramacionFuncional.XII_Repaso.lambdas.function;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        /*
        Function:
        Recibe un valor y retorna otro valor.
        Recibe un parámetro de tipo T (primer parametro ) y retorna un valor de tipo R (segundo parámetro).
         */
        Function<Integer, String> function = (num) -> {
            return "El numero es: " + num;
        };

        String result = function.apply(28);
        // se debe invocar el método apply() para obtener el valor, y se debe asignar a una variable.

        System.out.println(result);
    }
}
