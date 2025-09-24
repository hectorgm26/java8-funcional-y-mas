package ProgramacionFuncional.IV_ReferenciaMetodos;

public class Persona {

    String nombre;
    double estatura;

    public Persona() {
    }

    public Persona(String nombre, double estatura) {
        this.nombre = nombre;
        this.estatura = estatura;
    }

    // Como no es metodo estatico, si o si debo crear un objeto Persona para llamarlo
    public void saludar() {
        System.out.println("Hola, me llamo " + nombre);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", estatura=" + estatura +
                '}';
    }
}
