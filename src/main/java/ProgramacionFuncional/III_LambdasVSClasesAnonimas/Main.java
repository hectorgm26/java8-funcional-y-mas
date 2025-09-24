package ProgramacionFuncional.III_LambdasVSClasesAnonimas;

public class Main {
    public static void main(String[] args) {

        // Resuelto con clase anónima
        Operador suma = new Operador() {

            @Override
            public int operar(int num1, int num2) {
                return num1 + num2;
            }
        };
        System.out.println("La suma anonima es: " + suma.operar(10, 1));


        // Resuelto con lambdas
        Operador sumaL = (num1, num2) -> num1 + num2;
        System.out.println("La suma lambda es: " + sumaL.operar(10, 1));
    }
}

/*
UTILIZAR UNA U OTRA DEPENDE LA COMPLEJIDAD DEL PROBLEMA

- Si se tiene mas de un metodo, NO ES POSIBLE USAR LAMBDAS, y tendriamos que hacer una linea por cada implementacion de un metodo
- Si es un solo metodo, mejor usar lambdas
- En logicas complejas de un metodo, no es tan viable una lambda, ya que se pierde legibilidad
- Si tenemos herencia con un super con clases padre o this, es mejor una clase anonima, ya que con lambdas no se puede
*/