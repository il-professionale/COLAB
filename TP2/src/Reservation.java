import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    public enum Statut {
        EN_ATTENTE,
        CONFIRMEE,
        ANNULEE
    }

    private static int compteur = 1;

    private int id;
    private Client client;
    private Hebergement hebergement;

    private LocalDate dateArrivee;
    private LocalDate dateDepart;
    private LocalDate dateReservation;

    private double prixTotal;
    private Statut statut;

    public Reservation(Client client,
                       Hebergement hebergement,
                       LocalDate dateArrivee,
                       LocalDate dateDepart) {

        this.id = compteur++;
        this.client = client;
        this.hebergement = hebergement;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.dateReservation = LocalDate.now();
        this.statut = Statut.EN_ATTENTE;

        calculerPrixTotal();
    }

    public long getNombreNuits() {
        return ChronoUnit.DAYS.between(dateArrivee, dateDepart);
    }

    public void calculerPrixTotal() {

        long nuits = getNombreNuits();
        prixTotal = hebergement.getPrixParNuit() * nuits;

        if (client.aReduction()) {
            prixTotal *= 0.9;
        }
    }

    public void confirmer() {
        statut = Statut.CONFIRMEE;
    }

    public void annuler() {
        statut = Statut.ANNULEE;
    }

    public boolean estEnCours() {
        LocalDate today = LocalDate.now();
        return statut == Statut.CONFIRMEE &&
                !today.isBefore(dateArrivee) &&
                !today.isAfter(dateDepart);
    }

    public void afficherDetails() {
        System.out.println("------ Réservation ------");
        System.out.println("ID : " + id);
        System.out.println("Client : " + client.nom + " " + client.prenom);
        System.out.println("Hébergement : " + hebergement.getNom());
        System.out.println("Arrivée : " + dateArrivee);
        System.out.println("Départ : " + dateDepart);
        System.out.println("Nuits : " + getNombreNuits());
        System.out.println("Prix total : " + prixTotal + " €");
        System.out.println("Statut : " + statut);
    }
}