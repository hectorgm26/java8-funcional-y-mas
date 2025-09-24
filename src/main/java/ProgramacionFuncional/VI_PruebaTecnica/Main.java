package ProgramacionFuncional.VI_PruebaTecnica;

import ProgramacionFuncional.VI_PruebaTecnica.logica.Auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Auto> listaAutos = Arrays.asList(
                new Auto("Toyota", "Corolla", 20000),
                new Auto("Honda", "Civic", 22000),
                new Auto("Ford", "Focus", 21000),
                new Auto("Chevrolet", "Malibu", 25000),
                new Auto("Nissan", "Sentra", 23000),
                new Auto("Hyundai", "Elantra", 24000),
                new Auto("Kia", "Forte", 21000),
                new Auto("Volkswagen", "Jetta", 26000),
                new Auto("Mazda", "3", 27000),
                new Auto("Subaru", "Impreza", 28000),
                new Auto("BMW", "3 Series", 40000),
                new Auto("Audi", "A4", 42000),
                new Auto("Mercedes-Benz", "C-Class", 45000)
        );

        // 1. Ordenar por precio de menor a mayor con sort
        System.out.println("--- Ordenar por precio de menor a mayor ---");
        List<Auto> ordenPrecio = new ArrayList<Auto>(listaAutos);
        ordenPrecio.sort(Comparator.comparing(Auto::getCosto));
        // el metodo getCosto no es estatico, pero se usa la referencia a metodo igual ya que se esta llamando a traves de cada objeto Auto
        // se hace la comparacion de menor a mayor por defecto (con reverse() se haria de mayor a menor)

        ordenPrecio.forEach(System.out::println);


        // 2. Ordenar por marca y luego por precio usando sorted() - la diferencia entre sort y sorted es que sort es un metodo de List y sorted es un metodo de Stream
        System.out.println("--- Ordenar por marca y luego por precio ---");
        listaAutos.stream()
                .sorted(Comparator
                        .comparing(Auto::getMarca)
                        .thenComparing(Auto::getCosto))
                .forEach(System.out::println);


        // 3. Autos cuyo precio no supere los 23000
        System.out.println("--- Autos cuyo precio no supere los 23000 ---");
        listaAutos.stream()
                .filter(auto -> auto.getCosto() <= 23000)
                .forEach(System.out::println);


        // 4. Autos de marca Chevrolet o Wolkswagen
        System.out.println("--- Autos de marca Chevrolet o Wolkswagen ---");
        listaAutos.stream()
                .filter(auto -> auto.getMarca().equals("Chevrolet") || auto.getMarca().equals("Volkswagen"))
                .forEach(System.out::println);


        // 5. Autos cuyo modelo contenga al menos una letra "a"
        System.out.println("--- Autos cuyo modelo contenga al menos una letra 'a' ---");
        listaAutos.stream()
                .filter(auto -> auto.getModelo().toLowerCase().contains("a")) // recomendado usar toLowerCase() para evitar problemas con mayusculas y minusculas, ya que no existe containsIgnoreCase
                .forEach(System.out::println);
    }
}
