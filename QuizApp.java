import java.util.List;
import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("        QUIZ DEVOPS & OUTILS          ");
        System.out.println("======================================");
        System.out.println("Choisissez un mode :");
        System.out.println("  1) Quiz général (10 questions aléatoires)");
        System.out.println("  2) Linux");
        System.out.println("  3) Git");
        System.out.println("  4) Jenkins");
        System.out.println("  5) Docker");
        System.out.println("  6) DevOps");
        System.out.print("\nVotre choix (1-6) : ");

        int choixMenu = lireChoixMenu(scanner, 1, 6);
        List<Question> questions = selectionnerQuestions(choixMenu);

        int score = 0;
        int total = questions.size();

        for (int i = 0; i < total; i++) {
            Question q = questions.get(i);
            q.afficher(i + 1, total);

            char reponse = lireReponse(scanner);
            if (q.estCorrecte(reponse)) {
                System.out.println("Correct !");
                score++;
            } else {
                System.out.println("Faux ! La bonne réponse était : " + q.getBonneReponse());
            }
            System.out.println("Explication : " + q.getExplication());
        }

        afficherResultat(score, total);
        scanner.close();
    }

    private static List<Question> selectionnerQuestions(int choixMenu) {
        switch (choixMenu) {
            case 1:  return BanqueQuestions.getQuizGeneral(10);
            case 2:  return BanqueQuestions.getParCategorie("Linux");
            case 3:  return BanqueQuestions.getParCategorie("Git");
            case 4:  return BanqueQuestions.getParCategorie("Jenkins");
            case 5:  return BanqueQuestions.getParCategorie("Docker");
            case 6:  return BanqueQuestions.getParCategorie("DevOps");
            default: return BanqueQuestions.getQuizGeneral(10);
        }
    }

    private static int lireChoixMenu(Scanner scanner, int min, int max) {
        while (true) {
            String saisie = scanner.nextLine().trim();
            try {
                int valeur = Integer.parseInt(saisie);
                if (valeur >= min && valeur <= max) {
                    return valeur;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.print("Choix invalide. Entrez un nombre entre " + min + " et " + max + " : ");
        }
    }

    private static char lireReponse(Scanner scanner) {
        while (true) {
            System.out.print("Votre réponse (A, B, C ou D) : ");
            String saisie = scanner.nextLine().trim().toUpperCase();
            if (saisie.length() == 1 && "ABCD".indexOf(saisie.charAt(0)) != -1) {
                return saisie.charAt(0);
            }
            System.out.println("Veuillez saisir uniquement A, B, C ou D.");
        }
    }

    private static void afficherResultat(int score, int total) {
        double pourcentage = (total > 0) ? ((double) score / total) * 100.0 : 0.0;

        System.out.println("\n======================================");
        System.out.println("           RÉSULTAT FINAL             ");
        System.out.println("======================================");
        System.out.printf("Score       : %d / %d%n", score, total);
        System.out.printf("Pourcentage : %.1f %%%n", pourcentage);

        if (pourcentage >= 80) {
            System.out.println("Mention     : Excellent !");
        } else if (pourcentage >= 60) {
            System.out.println("Mention     : Bien, continuez comme ça.");
        } else {
            System.out.println("Mention     : À retravailler avec les supports de cours.");
        }
    }
}