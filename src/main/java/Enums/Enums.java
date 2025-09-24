package Enums;

public class Enums {

    private static PuntoCardinal direccion;
    private static PuntoCardinal punto;

    public Enums() {
        /*
        direccion = PuntoCardinal.ESTE;
        if (direccion == PuntoCardinal.OESTE) {
            System.out.println("Vamos hacia el oeste");
        } else {
            System.out.println("No vamos hacia el oeste");
        }

        // con los switch no hace falta el nombre del Enum delante de los case
        switch (direccion) {
            case NORTE:
                System.out.println("Vamos hacia el norte");
                break;
        }
        */
    }

    public static void main(String[] args) {
        punto = PuntoCardinal.NORTE;
        System.out.println("Sigla: " + punto.getSigla());

        PuntoCardinal siguiente = punto.girarHorario();
        System.out.println("Después de girar: " + siguiente + " (" + siguiente.getSigla() + ")");

        PuntoCardinal.values(); // Devuelve un array con todos los valores del enum
        var d2 = PuntoCardinal.valueOf("Este"); // Si existe un elemento con ese nombre lo devuelve, si no lanza una excepción

        if (punto == d2) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
    }
}
