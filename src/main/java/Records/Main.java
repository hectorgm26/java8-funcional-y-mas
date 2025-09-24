package Records;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona("Juan", LocalDate.now(), "Calle Falsa 123");
        System.out.println(persona);
        System.out.println(persona.getCalle());

        // Con records y DTOs
        PersonaDto personaDto = new PersonaDto("Héctor", LocalDate.now(), "Calle Falsa 321");
        System.out.println(personaDto);
        System.out.println(personaDto.calle());
        System.out.println(personaDto.fechaNacimiento());
        System.out.println(personaDto.nombre()); // Los metodos get no tienen la palabra get

        PersonaDto.metodoStatic();


        // Caso 2 - Trampa para moodificar un record con una lista mutable
        Producto arroz = new Producto("Arroz", 100);
        Producto fideo = new Producto("Fideo", 80);

        Carro carrito = new Carro();
        carrito.productos().add(arroz); // Se puede acceder al atributo sin el get
        carrito.productos().add(fideo);
        System.out.println("Cantidad de productos: " + carrito.cantidad());


        // Caso 3 - Modificar un record
        Producto p = new Producto("Arroz", 100);
        Producto q = p.copyWithNombre("Arroz Premium"); // Devolvemos una copia del record con el nuevo nombre

        System.out.println(p.toString());
        System.out.println(q.toString());
        System.out.println(q.copyWithNombre("Pollo").toString());
    }
}
