package ProgramacionFuncional.XII_Repaso.lambdas.bifunction;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {

        /*
        BiFunction
        Recibe dos valores y retorna un valor especifico
         */
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> {
            return a + b;
        };

        int result = biFunction.apply(10, 1);

        System.out.println(result);

    }
}
