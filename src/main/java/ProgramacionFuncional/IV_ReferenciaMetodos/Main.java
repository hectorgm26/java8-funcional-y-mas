package ProgramacionFuncional.IV_ReferenciaMetodos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

// Los metodos estaticos son aquellos que le pertenen a la clase y no a un objeto
// Una referencia a metodos permite usar un metodo ya existente sin tener que escribir
// una funcion anonima o lambda para ejecutarlo
// Es una forma compacta de usar lambdas cuando el codigo que queremos reutilizar ya esta definido en algun metodo
// Se usan dos puntos :: para separar el nombre de la clase o instancia del metodo
public class Main {
    public static void main(String[] args) {

        // ***************** Referencia a un metodo estatico *****************
        // Una interfaz funcional comun es Function<T, R>
        // T es el tipo de dato de entrada, que solo puede ser uno
        // R es el tipo de dato que devuelve
        Function<Integer, String> convertidor = String::valueOf; // lo que de resultado de String::valueOf se asigna a convertidor

        String resultado = convertidor.apply(35); // el metodo apply ejecuta la funcion con el metodo que le hayamos asignado
        System.out.println("El resultado es: " + resultado);


        // ***************** Referencia a un metodo de instancia de un objeto *****************
        Persona perso = new Persona();
        perso.nombre = "Hector";

        // La interfaz funcional Runnable para ejecutar cosas sin esperar una respuesta. Es decir ejecutar procedimiento que no devuelve nada, y no una funcion
        Runnable saludo = perso::saludar; // referencio al metodo saludar para ejecutar el metodo de ese objeto en base al parametro,
        // y no es necesario que el mmetodo sea estatico, ya que es de instancia, es decir, pertenece a un objeto

        saludo.run(); // el metodo run ejecuta la funcion con el metodo que le hayamos asignado


        // ***************** Referencia a un constructor *****************
        // la interfaz funcional bifunction<T, U, R> es una funcion que recibe dos parametros de entrada y devuelve un resultado
        // T y U son los dos tipos de datos de entrada, y R es el tipo de dato que devuelve
        BiFunction<String, Double, Persona> crearPersona = Persona::new;

        Persona personita = crearPersona.apply("Yanira", 1.70);
        System.out.println("La persona es: " + personita);

        // ***************** Referencia a un metodo de instancia de un objeto arbitrario *****************
        // Objeto arbitrario significa que no es un objeto en concreto, sino cualquier objeto de una clase o uno dentro de una coleccion
        List<Persona> personas = new ArrayList<>();
        personas.add(new Empleado());
        personas.add(new Gerente());
        personas.add(new Empleado());
        personas.add(new Gerente());

        personas.forEach(Persona::saludar); // al ser hijas de Persona, pueden usar su metodo saludar

    }
}

/*
Existen 4 tipos de referencias a metodos en Java:

- Referencia a un metodo estatico: usa un metodo que pertenece a la clase, o a un objeto
- Referencia a un metodo de instancia de un objeto: usa un metodo no estatico de un objeto existente
- Referencia a un metodo de instancia de un objeto arbitrario: usa un metodo no estatico de cualquier objeto de una clase
- Referencia a un constructor: crea un nuevo objeto llamando a un constructor
 */