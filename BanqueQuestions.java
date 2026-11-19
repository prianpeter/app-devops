import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BanqueQuestions {

    public static List<Question> getToutesLesQuestions() {
        List<Question> questions = new ArrayList<>();

        // ==================== LINUX (5 questions) ====================
        questions.add(new Question(
            "Linux",
            "Qu'ont en commun toutes les distributions Linux ?",
            new String[]{
                "L'interface graphique",
                "Le noyau Linux",
                "Le gestionnaire de paquets",
                "Le même fond d'écran"
            },
            'B',
            "Toutes les distributions partagent le même cœur : le noyau Linux."
        ));

        questions.add(new Question(
            "Linux",
            "Quelle commande affiche le dossier courant dans lequel vous vous trouvez ?",
            new String[]{"ls", "cd", "pwd", "whoami"},
            'C',
            "pwd (Print Working Directory) affiche le chemin absolu du dossier courant."
        ));

        questions.add(new Question(
            "Linux",
            "Que fait la commande : grep -i error app.log | wc -l ?",
            new String[]{
                "Elle compte les lignes contenant 'error' (sans tenir compte de la casse)",
                "Elle supprime les erreurs du fichier app.log",
                "Elle affiche les 10 premières erreurs",
                "Elle crée un fichier nommé error"
            },
            'A',
            "grep -i filtre les lignes contenant 'error' et wc -l compte le nombre de lignes."
        ));

        questions.add(new Question(
            "Linux",
            "Après la commande 'chmod 750 deploy.sh', que peut faire le groupe ?",
            new String[]{
                "Lire et exécuter",
                "Rien du tout",
                "Lire seulement",
                "Lire, écrire et exécuter"
            },
            'A',
            "7 = rwx (propriétaire), 5 = r-x (groupe : lecture 4 + exécution 1), 0 = --- (autres)."
        ));

        questions.add(new Question(
            "Linux",
            "Quelle commande démarre nginx immédiatement ET l'active à chaque démarrage du système ?",
            new String[]{
                "systemctl start nginx",
                "systemctl status nginx",
                "systemctl restart nginx",
                "systemctl enable --now nginx"
            },
            'D',
            "enable active le service au boot et --now le démarre immédiatement."
        ));

        // ==================== GIT (5 questions) ====================
        questions.add(new Question(
            "Git",
            "Quelle commande place un fichier modifié dans l'index (staging area) ?",
            new String[]{"git commit", "git add", "git push", "git init"},
            'B',
            "git add place les modifications dans l'index avant que git commit ne les enregistre."
        ));

        questions.add(new Question(
            "Git",
            "Vous venez de faire un 'git commit'. Votre travail est-il visible sur GitHub ?",
            new String[]{
                "Oui, immédiatement",
                "Oui, après un git pull",
                "Non, il faut d'abord faire git push",
                "Non, il faut d'abord créer un tag"
            },
            'C',
            "Le commit reste dans le dépôt local tant qu'il n'est pas envoyé avec git push."
        ));

        questions.add(new Question(
            "Git",
            "La version est 1.4.2. On corrige un bug sans ajouter de fonctionnalité. Quelle est la nouvelle version ?",
            new String[]{"1.4.3", "1.5.0", "2.0.0", "1.5.2"},
            'A',
            "En versionnement sémantique (MAJEUR.MINEUR.CORRECTIF), une correction de bug incrémente le 3e nombre."
        ));

        questions.add(new Question(
            "Git",
            "Quel fichier empêche Git de suivre le dossier out/ des classes compilées ?",
            new String[]{"README.md", ".gitignore", "App.java", ".git"},
            'B',
            "Le fichier .gitignore liste les fichiers et dossiers que Git ne doit pas suivre."
        ));

        questions.add(new Question(
            "Git",
            "Un commit erroné a déjà été poussé sur GitHub. Quelle est la bonne pratique pour l'annuler ?",
            new String[]{
                "git reset --hard <hash>",
                "git push --force",
                "git revert <hash>",
                "Supprimer le dépôt"
            },
            'C',
            "git revert crée un nouveau commit inverse, ce qui préserve l'historique partagé."
        ));

        // ==================== JENKINS (5 questions) ====================
        questions.add(new Question(
            "Jenkins",
            "Quelle pratique compile et teste automatiquement chaque modification poussée sur le dépôt ?",
            new String[]{
                "Le déploiement manuel",
                "L'intégration continue (CI)",
                "La revue de code",
                "Le versionnement sémantique"
            },
            'B',
            "L'intégration continue (CI) déclenche automatiquement la compilation et les tests à chaque push."
        ));

        questions.add(new Question(
            "Jenkins",
            "Où place-t-on le fichier Jenkinsfile d'un projet (Pipeline as Code) ?",
            new String[]{
                "Dans /var/lib/jenkins",
                "À la racine du dépôt Git",
                "Dans le dossier build/",
                "Sur le poste du développeur uniquement"
            },
            'B',
            "Le Jenkinsfile est versionné à la racine du dépôt Git, à côté du code source."
        ));

        questions.add(new Question(
            "Jenkins",
            "Quelle version de Java faut-il pour faire tourner la LTS actuelle de Jenkins ?",
            new String[]{"Java 8", "Java 11", "Java 17", "Java 21 ou 25"},
            'D',
            "Jenkins LTS exige Java 21 ou 25 pour fonctionner."
        ));

        questions.add(new Question(
            "Jenkins",
            "Un test échoue et le script test.sh renvoie le code de retour 1. Quel est le résultat du build ?",
            new String[]{"SUCCESS", "UNSTABLE", "FAILURE", "ABORTED"},
            'C',
            "Une étape sh qui renvoie un code différent de 0 fait échouer le pipeline (FAILURE)."
        ));

        questions.add(new Question(
            "Jenkins",
            "Quel bloc du Jenkinsfile permet d'enregistrer les résultats JUnit même quand les tests échouent ?",
            new String[]{
                "post { always { junit ... } }",
                "options { junit ... }",
                "environment { junit ... }",
                "triggers { junit ... }"
            },
            'A',
            "Le bloc post { always { ... } } s'exécute systématiquement, même en cas d'échec du stage."
        ));

        // ==================== DOCKER (5 questions) ====================
        questions.add(new Question(
            "Docker",
            "Quelle phrase décrit le mieux la différence entre une image et un conteneur ?",
            new String[]{
                "Ce sont deux noms pour la même chose",
                "L'image est un modèle figé ; le conteneur en est une instance qui tourne",
                "Le conteneur est un fichier ; l'image est un processus",
                "L'image tourne sur l'hôte ; le conteneur dans une VM"
            },
            'B',
            "Image = modèle en lecture seule (classe) ; Conteneur = instance en cours d'exécution (objet)."
        ));

        questions.add(new Question(
            "Docker",
            "Quelle instruction obligatoire définit l'image de départ d'un Dockerfile ?",
            new String[]{"FROM", "RUN", "COPY", "ENTRYPOINT"},
            'A',
            "FROM est toujours la première instruction d'un Dockerfile et indique l'image de base."
        ));

        questions.add(new Question(
            "Docker",
            "Que signifie l'option '-p 8081:8080' dans la commande docker run ?",
            new String[]{
                "Le conteneur utilise 8081 Mo de mémoire",
                "Port 8080 de l'hôte vers le port 8081 du conteneur",
                "Port 8081 de l'hôte vers le port 8080 du conteneur",
                "Le conteneur est limité à 8 processeurs"
            },
            'C',
            "La syntaxe est toujours -p port_hote:port_conteneur."
        ));

        questions.add(new Question(
            "Docker",
            "On supprime un conteneur avec 'docker rm'. Que deviennent les fichiers qu'il a écrits ?",
            new String[]{
                "Ils sont copiés dans l'image",
                "Ils restent dans /tmp de l'hôte",
                "Ils sont envoyés sur Docker Hub",
                "Ils sont perdus, sauf ceux écrits dans un volume"
            },
            'D',
            "La couche en écriture d'un conteneur est éphémère ; seuls les volumes survivent à docker rm."
        ));

        questions.add(new Question(
            "Docker",
            "Quel est le principal intérêt d'un build multi-étapes (multi-stage) dans un Dockerfile ?",
            new String[]{
                "Obtenir une image finale sans JDK ni code source, donc plus légère",
                "Rendre le build plus lent mais plus sûr",
                "Pouvoir lancer deux conteneurs en même temps",
                "Remplacer le Jenkinsfile"
            },
            'A',
            "L'étape de build compile avec le JDK, puis seul le .jar est copié dans l'image finale (JRE seul)."
        ));

        // ==================== DEVOPS (5 questions) ====================
        questions.add(new Question(
            "DevOps",
            "Quelle est la principale limite du modèle Waterfall (en cascade) ?",
            new String[]{
                "Il manque de documentation à chaque étape",
                "Il est très rigide face au changement",
                "Le client voit le produit trop tôt",
                "Il ne convient à aucun type de projet"
            },
            'B',
            "Le modèle Waterfall est séquentiel et en silos, ce qui rend les changements tardifs très coûteux."
        ));

        questions.add(new Question(
            "DevOps",
            "Que signifie l'acronyme CALMS en DevOps ?",
            new String[]{
                "Culture, Automation, Lean, Measurement, Sharing",
                "Code, Automation, Lean, Monitoring, Speed",
                "Culture, Agile, Lean, Measurement, Scrum",
                "Continuous, Automation, Loop, Monitoring, Sharing"
            },
            'A',
            "CALMS désigne les 5 piliers du DevOps : Culture, Automation, Lean, Measurement et Sharing."
        ));

        questions.add(new Question(
            "DevOps",
            "Qu'est-ce que le DevOps ?",
            new String[]{
                "Une méthodologie de développement logiciel uniquement",
                "Un outil permettant d'automatiser le déploiement",
                "Un langage permettant de décrire l'infrastructure",
                "Une culture, des pratiques et des outils favorisant la collaboration entre Dev et Ops"
            },
            'D',
            "Le DevOps n'est pas un simple outil mais une philosophie de collaboration continue entre Dev et Ops."
        ));

        questions.add(new Question(
            "DevOps",
            "Quel outil sert principalement à l'orchestration de conteneurs à grande échelle ?",
            new String[]{"Terraform", "Kubernetes", "Ansible", "Jenkins"},
            'B',
            "Kubernetes orchestre les conteneurs (mise à l'échelle, auto-réparation, répartition de charge)."
        ));

        questions.add(new Question(
            "DevOps",
            "Un fournisseur cloud héberge l'infrastructure et le runtime, mais vous gérez votre code et vos données. Quel modèle est-ce ?",
            new String[]{"IaaS", "PaaS", "SaaS", "On-Premise"},
            'B',
            "En PaaS (Platform as a Service), vous déployez simplement votre code sur une plateforme gérée."
        ));

        return questions;
    }

    public static List<Question> getParCategorie(String categorie) {
        List<Question> filtrees = getToutesLesQuestions().stream()
            .filter(q -> q.getCategorie().equalsIgnoreCase(categorie))
            .collect(Collectors.toList());
        Collections.shuffle(filtrees);
        return filtrees;
    }

    public static List<Question> getQuizGeneral(int nombreQuestions) {
        List<Question> toutes = new ArrayList<>(getToutesLesQuestions());
        Collections.shuffle(toutes);
        return toutes.subList(0, Math.min(nombreQuestions, toutes.size()));
    }
}