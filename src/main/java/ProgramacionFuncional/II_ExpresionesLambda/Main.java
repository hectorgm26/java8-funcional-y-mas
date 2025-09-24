package ProgramacionFuncional.II_ExpresionesLambda;

import ProgramacionFuncional.II_ExpresionesLambda.model.Mensajero;
import ProgramacionFuncional.II_ExpresionesLambda.model.Mensajero2;
import ProgramacionFuncional.II_ExpresionesLambda.model.Mensajero3;

// Una funcion lambda es una manera de representar una funcion sin tener que escribir toda la estructura de un metodo
// Se integran a Java desde el JDK 8
// Basicamente implementan metodos sin necesidad de una clase
public class Main {
    public static void main(String[] args) {

        // *************** EJEMPLO 1 ***************
        // Se asigna la expresion lambda, a una variable del tipo de la interfaz funcional,
        // y asi se implementa el metodo unico de la interfaz funcional, suplantando el metodo
        Mensajero lambdaMsje = () -> {
            System.out.println("Hola desde una expresion lambda");
        };
        lambdaMsje.emitirMensaje();


        // *************** EJEMPLO 2 ***************
        // En el parametro NO ES NECESARIO COLOCAR EL TIPO DE DATO, ya que Java lo infiere de la interfaz funcional
        Mensajero2 lambdaMsje2 = (String nombre) -> {
            System.out.println("Hola " + nombre + " desde una expresion lambda");
        };
        lambdaMsje2.emitirMensaje("Juan");


        // *************** EJEMPLO 3 ***************
        // Mas de una sentencia en el cuerpo del metodo
        Mensajero3 lambdaMsje3 = (nombre, edad) -> {
            System.out.println("Hola " + nombre + " desde una expresion lambda");
            System.out.println("Tienes " + edad + " años");
        };
        lambdaMsje3.emitirMensaje("Hector", 28);
    }
}

/*
EJEMPLOS DE SINTAXIS:

Sin parametros: () -> sentencia o {sentencias}, si es mas de una sentencia se usan llaves {} y si es solo una linea, es opcional
Con un parametro: Parametro -> sentencia
Con mas de un parametro: (Parametro1, Parametro2) -> sentencia
Con mas de una sentencia: (Parametro) -> { sentencia1;
                                           sentencia2;}

Para poder utilizar expresiones lambdas es necesario implementar una interfaz funcional
El lado izquierdo representa los parametros que se le pasaran a las sentencias del lado derecho
Los lados se separan por una flecha "->" que es una funcion flecha
Del lado derecho cada una de las lineas de codigo son las lineas que iran dentro del metodo
Cada linea de codigo del metodo deben ir separados por un punto y coma ;
*/

/*
INTERFACES FUNCIONALES
Son un tipo especial de interfaz por tener un solo metodo abstracto e implementar ese unico metodo abstracto
Un metodo es abstracto cuando no tiene su implementacion de codigo dentro (solo titulo y tipo de dato que devuelve)

Ejemplo: la interfaz Runnable
@FunctionalInterface // Esta anotacion es opcional pero recomendable para indicar que es una interfaz funcional
public interface Runnable {
    public abstract void run();
}

Podemos crear nuestras propias interfaces funcionales o usar las que ya existen en Java
Se crean con la anotacion @FunctionalInterface y abajo un unico metodo abstracto de una interfaz normal (ES OPCIONAL LA ANOTACIOM PERO RECOMENDADO)

*/