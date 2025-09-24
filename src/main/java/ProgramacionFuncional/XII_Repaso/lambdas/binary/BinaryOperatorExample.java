package ProgramacionFuncional.XII_Repaso.lambdas.binary;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {

        /*
        BinaryOperator:
        Recibe dos valores del mismo tipo y retorna un valor del mismo tipo.
        Solamente se coloca un tipo genérico dentro de los corchetes angulares, ya que se asume que ambos parámetros y el retorno son del mismo tipo.
         */
        BinaryOperator<Integer> binaryOperator = (a, b) -> {
            return a + b;
        };

        int result = binaryOperator.apply(5, 10); // con apply se ejecuta la lambda

        System.out.println("Result: " + result); // Result: 15
    }

}
