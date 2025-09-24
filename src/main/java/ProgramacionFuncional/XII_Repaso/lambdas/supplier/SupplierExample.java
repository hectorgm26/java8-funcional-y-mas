package ProgramacionFuncional.XII_Repaso.lambdas.supplier;

import java.util.function.Supplier;

/*
Aquí, <String> no es el tipo que recibe (porque no recibe nada), sino el tipo que va a retornar.
Equivalente a:
public String proveer() {
    return "Hola, soy un Supplier";
}
 */
public class SupplierExample {
    public static void main(String[] args) {

        /*
        Supplier:
        No recibe ningun valor, pero retorna un valor.
         */

        Supplier<String> supplier = () -> {
            return "Hola, soy un Supplier";
        };

        String result = supplier.get();
        // se debe invocar el método get() para obtener el valor, y se debe asignar a una variable.
        System.out.println(result);
    }
}
