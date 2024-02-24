package exercice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListMot {
    public static void main(String[] args) {
        ArrayList<String> listMot = new ArrayList<>();
        listMot.add("Java");
        listMot.add("Javascript");
        listMot.add("phyton");
        listMot.add("PHP");
        listMot.add("Go");
        listMot.add("C");

        //1. ressortir les mots qui contiennent "a"
        listMot.stream()
                .filter(mot -> mot.contains("a"))
                .forEach(System.out::println);

        // 2. rechercher les mot qui ont plus de 3 caractères et retourner leur inverse
        listMot.stream()
                .filter(mot -> mot.length() > 3 )
                .map(mot -> new StringBuilder(mot).reverse())
                .forEach(System.out::println);

        // 3.listrer les chaines qui contiennent e et les retourner lettre par lettre
        listMot.stream()
                .filter(mot -> mot.contains("e"))
                .flatMap(mot -> Stream.of(mot.toCharArray()))
                .forEach(System.out::println);

        // 4. retourner chaque mot en majuscule
        listMot.stream()
                .map(String::toUpperCase) //.map(mot -> mot.toUpperCase()) signifie la même chose
                .forEach(System.out::println);

        // 5. Convertir chaque chaine en sa longueur
        listMot.stream()
                .map(String::length) //map(mot -> mot.length()) la même chose
                .forEach(System.out::println);

        // 6.
        listMot.stream()
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .forEach(System.out::println);
    }
}
