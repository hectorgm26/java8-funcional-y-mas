package ProgramacionFuncional.XII_Repaso.lambdas.bipredicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {

        /*
        BiPredicate:
        Recibe dos valores y devuelve un booleano (true o false).
         */
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> {
            return a > b; // si es correcto devuelve true, si no false
        };

        boolean result = biPredicate.test(10, 5); // con el metodo test evaluamos el bipredicado

        System.out.println(result);
    }
}
