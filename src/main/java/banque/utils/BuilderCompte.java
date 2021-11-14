package banque.utils;

import banque.entity.compte.AssuranceVie;
import banque.entity.compte.Compte;
import banque.entity.compte.LivretA;
import banque.repository.CompteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class BuilderCompte {

    private static final List<Compte> COMPTES = new ArrayList<>();

    private BuilderCompte() {
    }

    public static List<Compte> getComptes() {
        createCompte();
        CompteRepository repository = new CompteRepository();
        COMPTES.forEach(repository::save);
        return COMPTES;
    }

    private static void createCompte() {
        Compte c1 = new AssuranceVie(LocalDate.of(2031, 1, 19), 4.3);
        Compte c2 = new AssuranceVie(LocalDate.of(2024, 5, 12), 3.7);
        Compte c3 = new AssuranceVie(LocalDate.of(2027, 9, 2), 3.0);
        Compte c4 = new AssuranceVie(LocalDate.of(2025, 12, 5), 2.3);
        Compte c5 = new AssuranceVie(LocalDate.of(2023, 6, 17), 2.5);
        Compte c6 = new LivretA(2.5);
        Compte c7 = new LivretA(3.1);
        Compte c8 = new LivretA(2.9);
        Compte c9 = new LivretA(3.5);
        Compte c10 = new LivretA(2.3);
        COMPTES.add(assignmentCompte(c1));
        COMPTES.add(assignmentCompte(c2));
        COMPTES.add(assignmentCompte(c3));
        COMPTES.add(assignmentCompte(c4));
        COMPTES.add(assignmentCompte(c5));
        COMPTES.add(assignmentCompte(c6));
        COMPTES.add(assignmentCompte(c7));
        COMPTES.add(assignmentCompte(c8));
        COMPTES.add(assignmentCompte(c9));
        COMPTES.add(assignmentCompte(c10));
    }

    private static Compte assignmentCompte(Compte compte) {
        compte.setNumero(createNumeroCompte());
        compte.setSolde(createSolde());
        return compte;
    }

    private static String createNumeroCompte() {
        Long rand = new Random().nextInt(1967687565) + 16789357678L;
        Integer randKey = new Random().nextInt(91) + 10;
        Integer randChar = new Random().nextInt(26) + 1;
        StringBuilder numeroCompte = new StringBuilder()
                .append(rand)
                .append(randKey)
                .append(" ")
                .append((char) (randChar + 'A' - 1));
        return numeroCompte.toString();
    }

    private static Double createSolde() {
        return (double) new Random().nextInt(1976) + 1976;
    }
}
