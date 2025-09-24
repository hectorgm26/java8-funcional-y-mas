package Records;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {

    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final String calle;

    public Persona(String nombre, LocalDate fechaNacimiento, String calle) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCalle() {
        return calle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(fechaNacimiento, persona.fechaNacimiento) && Objects.equals(calle, persona.calle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento, calle);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", calle='" + calle + '\'' +
                '}';
    }
}
