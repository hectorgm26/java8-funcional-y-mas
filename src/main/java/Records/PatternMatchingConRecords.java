package Records;

public class PatternMatchingConRecords {

    public record Punto(double x, double y) {
    }

    // El sealed interface solo puede ser implementado por las clases que se declaren en el mismo fichero
    // Es decir la interface solo puede ser un Rectangulo, Cuadrado o Triangulo
    // Esto permite omitir el default en el switch del patroon matching
    public sealed interface Geometria {
    }

    public record Rectangulo(Punto centro, double ancho, double alto) implements Geometria {

    }

    public record Cuadrado(Punto centro, double lado) implements Geometria {

    }

    public record Triangulo(Punto centro, double base, double altura) implements Geometria {

    }

    // Destructuring con records y pattern matching desde JAVA 19
    // En vez de utilizar r.ancho y r.alto se podra sustituir r
    // por una expresion entre parentesis que extrae automaticamente los valores de las variables
    // que conforman los campos que hay dentro del record
    // Y asi poder utilizarlos directamente haciendo uso de ellos extrayendolos
    // Los campos deben estar en el mismo orden del record original, y si no se necesita uno, se coloca igual e ignorarlo
    // PERO EN JAVA 22, se puede colocar var _ (usar guion bajo) para ignorar el campo que no se va a usar, pero en el mismo orden igualmente
    /*
        public static double area(Geometria g) {
            if (g instanceof Rectangulo(var punto, double ancho, double alto)) {

            }

            if (g instanceof Cuadrado c) {
                c.lado();
                c.centro();
                return c.lado() * c.lado();
            }
        }
     */

    /*
        public static double area(Geometria g) {
            return switch (g) {
                case Rectangulo (Punto(var x, var y), double ancho, double alto) -> ancho * alto;
                case Cuadrado (var _, double lado) -> lado * lado;
                case Triangulo (var _, double base, double altura) -> (base * altura) / 2;
                default -> throw new IllegalArgumentException("Geometria no soportada");
            };
        }
    */

    public static void main(String[] args) {


    }
}
