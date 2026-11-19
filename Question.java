public class Question {
    private final String categorie;
    private final String enonce;
    private final String[] choix; // 4 choix : A, B, C, D
    private final char bonneReponse; // 'A', 'B', 'C' ou 'D'
    private final String explication;

    public Question(String categorie, String enonce, String[] choix, char bonneReponse, String explication) {
        if (choix == null || choix.length != 4) {
            throw new IllegalArgumentException("Une question doit avoir exactement 4 choix.");
        }
        this.categorie = categorie;
        this.enonce = enonce;
        this.choix = choix;
        this.bonneReponse = Character.toUpperCase(bonneReponse);
        this.explication = explication;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getEnonce() {
        return enonce;
    }

    public String[] getChoix() {
        return choix;
    }

    public char getBonneReponse() {
        return bonneReponse;
    }

    public String getExplication() {
        return explication;
    }

    public boolean estCorrecte(char reponseUtilisateur) {
        return Character.toUpperCase(reponseUtilisateur) == this.bonneReponse;
    }

    public void afficher(int numero, int total) {
        System.out.println("\n--- Question " + numero + "/" + total + " [" + categorie + "] ---");
        System.out.println(enonce);
        char lettre = 'A';
        for (String option : choix) {
            System.out.println("  " + lettre + ") " + option);
            lettre++;
        }
    }
}