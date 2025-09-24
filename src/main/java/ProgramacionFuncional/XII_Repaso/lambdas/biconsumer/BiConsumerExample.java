package ProgramacionFuncional.XII_Repaso.lambdas.biconsumer;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {

        /*
        BiConsumer:
        Recibe dos valores y no retorna nada
         */
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println(a + " " + b);
        };

        biConsumer.accept("Hola", "Mundo"); // con accept se ejecuta el biConsumer
    }
}
