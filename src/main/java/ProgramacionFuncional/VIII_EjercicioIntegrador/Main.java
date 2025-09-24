package ProgramacionFuncional.VIII_EjercicioIntegrador;

import ProgramacionFuncional.VIII_EjercicioIntegrador.logica.Cliente;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Cliente> listaClientes = obtenerClientes();

        System.out.println("-------- Bienvenidos a Envios HayaBooks");
        System.out.println("Ingrese el numero de cliente a enviar un paquete");

        Long numero = Long.parseLong(input.nextLine());

        // Buscar cliente por numero de cliente
        Optional<Cliente> cliente = buscarCliente(listaClientes, numero);

        // Verificar cliente
        if (cliente.isPresent()) {
            // Si el cliente existe, buscaremos su direccion
            Optional<String> direccion = obtenerDireccion(cliente);

            // Verificar si obtuvo direccion o no
            if (direccion.isPresent()) {
                System.out.println("La direccion del cliente es: " + direccion.get());
            } else {
                System.out.println("El cliente no posee direccion registrada");
            }

        } else {
            System.out.println("El cliente en cuestion no existe");
        }


    }

    private static Optional<String> obtenerDireccion(Optional<Cliente> cliente) {
        return cliente
                .map(Cliente::getDireccion);
        // el map de Optional transforma el valor si esta presente, en otro valor
        // el map aqui no aplica una funcion, sino que aplica un metodo de la clase Cliente
        // que devuelve un String, y ese String sera el valor del Optional<String>
    }

    private static Optional<Cliente> buscarCliente(List<Cliente> listaClientes, Long numero) {
        return listaClientes.stream()
                .filter(cliente -> cliente.getNro_cliente().equals(numero))
                .findFirst();
    }

    private static List<Cliente> obtenerClientes() {
        List<Cliente> clientes = Arrays.asList(
                new Cliente(1L, "Juan", "Pérez", null, "1111-1111"),
                new Cliente(2L, "María", "Gómez", "Av. Siempre Viva 742", "2222-2222"),
                new Cliente(3L, "Carlos", "López", "Mitre 100", "3333-3333"),
                new Cliente(4L, "Lucía", "Martínez", "Belgrano 456", "4444-4444"),
                new Cliente(5L, "Ana", "Fernández", "San Martín 789", "5555-5555"),
                new Cliente(6L, "Pedro", "Sánchez", null, "3333-4444"),
                new Cliente(7L, "Laura", "Díaz", "Corrientes 202", "7777-7777"),
                new Cliente(8L, "Diego", "Ramírez", null, "8888-8888"),
                new Cliente(9L, "Suscribite", "Todocode", "Internet 404", "9999-9999"),
                new Cliente(10L, "Valeria", "Acosta", null, "0000-0000")
        );
        return clientes;
    }


}
