package Records;

// Un record en simple es un contenedor de informacion que le podemos pasar parametros sobre que campos se metan
// Los records por su naturaleza seran final, por ende no se pueden extender , ni tener setters
// Si se tiene un constructor adicional, debe llamar si o si al constructor principal
public record Producto(String nombre, int precio) {

    // No podemos cambiar el valor de un atributo, PERO podemos devolver una copia del record con la modifiacion del atributo
    public Producto copyWithNombre(String nombre) {
        return new Producto(nombre, this.precio); // Devolvemos una copia del record con el nuevo nombre, manteniedo el precio actual
    }

    public Producto copyWithPrecio(int precio) {
        return new Producto(this.nombre, precio);
    }
}
