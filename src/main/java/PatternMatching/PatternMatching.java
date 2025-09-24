package PatternMatching;

public class PatternMatching {

    public static void main(String[] args) {
        Verdura v = new Verdura();
        var p = new Patata();
        var c = new CocaCola();

        comprobar(v);
        comprobar(p);
        comprobar(c);
    }

    // Instanceof es para verificar si un tipo de variable es de un tipo determinado o que extienda de ella o que implemente una interfaz
    public static void comprobar(Object obj) {
        if (obj instanceof Verdura) {

            // Una vez comprobada la instancia, podemos hacer un casting
            Verdura ver = (Verdura) obj;
            ver.comer();
            System.out.println("Es una verdura");
        } else {
            System.out.println("No es una verdura");
        }
    }

    // Pattern matching con instanceof (en 16 en preview, ya en 17 estable)
    public static void comprobar2(Object obj) {

        // Se hace un casteo implicito agregandole al final una variable,
        // que extraera propiedades, siendo el resultado una variable del tipo que se esta comprobando
        if (obj instanceof Patata pa) {
            pa.comer();
            System.out.println("Es una verdura");

        } else if (obj instanceof Verdura ver) {
            ver.comer();
            System.out.println("Es una verdura");

        } else {
            System.out.println("No es una verdura");
        }
    }

    /*
    // Pattern matching con switch (desde java 17 en preview, y en java 21 ya estandarizado)

    public static void comprobar3(Object obj) {
        switch (obj) {
            // Se coloca el tipo a comprobar, y una variable que extraera las propiedades
            // y debe si o si ser exaustivo, es decir, tener un default
            case Patata pa -> {
                pa.comer();
                System.out.println("Es una patata");
            }
            case Verdura ver -> {
                ver.comer();
                System.out.println("Es una verdura");
            }
            default -> System.out.println("No es una verdura");
        }
    }
    */
}
