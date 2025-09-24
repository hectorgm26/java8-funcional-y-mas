package Records;

import java.time.LocalDate;
import java.util.Objects;

// Los records fueron introducidos en Java 14 como una forma concisa de definir clases inmutables
// Los parentesis son el constructor primario con atributos de tipo final
// Los metodos tipicos como equals, hashCode y toString, getters son generados automaticamente
// Utles en DTOs para guardar y transportar datos
public record PersonaDto(
        String nombre,
        LocalDate fechaNacimiento,
        String calle
) {

    // Podemos agregar logica en nuestro constructor principal del record
    public PersonaDto {
        Objects.requireNonNull(nombre); // Que el atributo no sea nulo
        if (fechaNacimiento == null) {
            fechaNacimiento = LocalDate.now(); // Si es nulo, le asignamos la fecha actual
        }
    }

    // Podemos tener atributos estaticos
    public static String ATRIBUTO_STATIC = "Hola";

    // Los records pueden tener multiples constructores
    public PersonaDto(String nombre) {
        this(nombre, LocalDate.now(), "Calle Falsa 234"); // Este constructor es diferente, ya que solo recibe el nombre y en this asigna valores por defecto a los otros atributos
    }

    // Podemos crear metodos estaticos
    public static void metodoStatic() {
        System.out.println("Metodo static en un record");
    }
}
