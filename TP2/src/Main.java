import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Hebergement {
    // Attributs
    private int id;
    private String nom;
    private String adresse;
    private String type; // ex: "Hôtel", "Appartement", "Villa"
    private int capaciteMax; // nombre maximal de personnes
    private double prixParNuit;
    private String description;
    private List<String> equipements; // ex: "WiFi", "Télé", "Cuisine"
    private List<Periode> disponibilites; // périodes disponibles
    private List<Double> notes; // liste des notes attribuées
    private List<String> commentaires; // commentaires des clients

    // Constructeur
    public Hebergement(int id, String nom, String adresse, String type, int capaciteMax, double prixParNuit, String description) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.capaciteMax = capaciteMax;
        this.prixParNuit = prixParNuit;
        this.description = description;
        this.equipements = new ArrayList<>();
        this.disponibilites = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.commentaires = new ArrayList<>();
    }

    // Méthodes pour gérer les équipements
    public void ajouterEquipement(String equipement) {
        this.equipements.add(equipement);
    }

    public void retirerEquipement(String equipement) {
        this.equipements.remove(equipement);
    }

    // Méthodes pour gérer les disponibilités
    public void ajouterDisponibilite(LocalDate debut, LocalDate fin) {
        disponibilites.add(new Periode(debut, fin));
    }

    public void supprimerDisponibilite(LocalDate debut, LocalDate fin) {
        disponibilites.removeIf(p -> p.getDebut().equals(debut) && p.getFin().equals(fin));
    }

    public boolean estDisponible(LocalDate debut, LocalDate fin) {
        for (Periode p : disponibilites) {
            if (!debut.isAfter(p.getFin()) && !fin.isBefore(p.getDebut())) {
                return true; // chevauchement trouvé
            }
        }
        return false;
    }

    // Méthode pour calculer le prix total d'un séjour
    public double calculerPrixTotal(int nbNuits) {
        return prixParNuit * nbNuits;
    }

    // Méthode pour ajouter une note et recalculer la moyenne
    public void ajouterNote(double note) {
        if (note >= 0 && note <= 5) {
            notes.add(note);
        } else {
            System.out.println("Note invalide. Doit être entre 0 et 5.");
        }
    }

    public double getMoyenneNotes() {
        if (notes.isEmpty()) return 0;
        double somme = 0;
        for (double n : notes) somme += n;
        return somme / notes.size();
    }

    // Ajouter un commentaire
    public void ajouterCommentaire(String commentaire) {
        commentaires.add(commentaire);
    }

    // Résumé complet
    public void afficherResume() {
        System.out.println("Nom: " + nom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Type: " + type);
        System.out.println("Capacité max: " + capaciteMax);
        System.out.println("Prix par nuit: " + prixParNuit + " €");
        System.out.println("Description: " + description);
        System.out.println("Équipements: " + String.join(", ", equipements));
        System.out.println("Disponibilités: ");
        for (Periode p : disponibilites) {
            System.out.println("- du " + p.getDebut() + " au " + p.getFin());
        }
        System.out.println("Moyenne des notes: " + getMoyenneNotes());
        System.out.println("Commentaires: ");
        for (String c : commentaires) {
            System.out.println("- " + c);
        }
    }

    // Classe interne pour gérer les périodes de disponibilité
    private class Periode {
        private LocalDate debut;
        private LocalDate fin;

        public Periode(LocalDate debut, LocalDate fin) {
            this.debut = debut;
            this.fin = fin;
        }

        public LocalDate getDebut() {
            return debut;
        }

        public LocalDate getFin() {
            return fin;
        }
    }
}
