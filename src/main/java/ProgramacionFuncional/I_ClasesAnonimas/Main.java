package ProgramacionFuncional.I_ClasesAnonimas;

// Las clases anonimas son clases que no tienen nombre y se definen en el mismo lugar donde se usan
// Estas pueden usarse en conjunto con clases e unterfaces
// Implementan herencia para implementar interfaces, o puede heredar de una clase madre
public class Main {

    public static void main(String[] args) {

        // *********** EJEMPLO 1 **************
        // Haremos un perro, pero no creando una clase, sino anonimanente implementando la interfaz Animal
        Animal perro = new Animal() {

            @Override
            public void hacerSonido() {
                System.out.println("Hola yo ladro GUAU!");
            }
        }; // las clases anonimas siempre van con un punto y coma ; para definir donde termina

        perro.hacerSonido();
        // se le puede llamar al metodo hacerSonido() porque la clase anonima implementa la interfaz Animal


        // *********** EJEMPLO 2 **************
        // Crear clase anonima que herede de Vehiculo con atributos y metodos PROPIOS de la clase anonima
        new Vehiculo() {
            private int numPasajeros;

            public void manejar() {
                System.out.println("Estoy manejando");
            }
        }.manejar();
        // para llamar a metodos propios de la clase anonima, se les llama entre la llave de cierre y el punto y coma
        // con un . y el nombre del metodo
        // la clase anonima en si es un objeto que no tiene nombre, y podemos hacer uso de sus metodos
        // no se pueden llamar como un objeto normal porque no tiene nombre, y porque la clase Vehiculo no tiene esos metodos
        // Si no que quien tiene el metodo es la clase anonima que hereda de Vehiculo

    }
}
