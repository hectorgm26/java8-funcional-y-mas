package ProgramacionFuncional.XII_Repaso.lambdas.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        /*
        Predicate:
        Recibe un valor y devuelve un booleano (true o false).
         */
        Predicate<String> predicate = (str) -> {
            return str.length() > 5; // si es correcto devuelve true, si no false
        };

        boolean result = predicate.test("Hola Mundo"); // con el metodo test evaluamos el predicado

        System.out.println(result);
    }
}
