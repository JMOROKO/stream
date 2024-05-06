package exercice2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class main {
    public static void main(String[] args) {
        ArrayList<Employe> listEmploye = new ArrayList<>();

        Employe koffi = new Employe("KOFFI", "IT", 2000);
        Employe mokobe = new Employe("Mokobe", "Info", 1000);
        Employe tzu = new Employe("tzu", "Qi", 2800);

        listEmploye.add(koffi);
        listEmploye.add(mokobe);
        listEmploye.add(tzu);

        //1. Utiliser mapToDouble et sum pour calculer la somme totale des salaires de tous les
        //employés.
        double sommeSalaire = listEmploye.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();

        System.out.println(sommeSalaire);

        //2. Utiliser sorted pour trier la liste des employés par ordre alphabétique du nom.
        listEmploye.stream()
                .map(Employe::getNom)
                .sorted()
                .forEach(System.out::println);

        //3. Utiliser min pour trouver l'employé avec le salaire le plus bas.
        Optional<Employe> employeSalaireMin = listEmploye.stream()
                .min(Comparator.comparingDouble(Employe::getSalaire));
        System.out.println(employeSalaireMin.get());


        //4. Utiliser filter pour obtenir la liste des employés ayant un salaire supérieur à une valeur donnée.
        listEmploye.stream()
                .map(Employe::getSalaire)
                .filter(salaire -> salaire > 1000)
                .forEach(System.out::println);

        //5.Utilisez reduce pour trouver l'employé avec le salaire le plus élevé dans l'ensemble de l'entreprise.
        Optional<Employe> employeSalaireMax = listEmploye.stream()
                .reduce((emp1, emp2) -> emp1.getSalaire() > emp2.getSalaire() ? emp1 : emp2);

        System.out.println(employeSalaireMax.get());

        // 6. Utilisez reduce pour concaténer les noms de tous les employés
        String concatenerNom = listEmploye.stream()
                .map(Employe::getNom)
                .reduce("", (nom1, nom2) -> nom1 + ", " + nom2 );
        System.out.println(concatenerNom);
    }
}
