package ProgramacionFuncional.XII_Repaso.lambdas.unary;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {

        /*
        UnaryOperator:
        Recibe un valor, lo procesa y devuelve un resultado del mismo tipo
         */
        UnaryOperator<Integer> unaryOperator = (number) -> {
            return number * number;
        };

        int result = unaryOperator.apply(5); // con apply se ejecuta la lambda

        System.out.println("El resultado es: " + result); // El resultado es: 25
    }
}
