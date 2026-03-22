import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    public enum Statut {
        EN_ATTENTE,
        CONFIRMEE,
        ANNULEE
    }

    private static int compteur = 1;

    private int          id;
    private Client       client;
    private Hebergement  hebergement;
    private LocalDate    dateArrivee;
    private LocalDate    dateDepart;
    private LocalDate    dateReservation;
    private double       prixTotal;
    private Statut       statut;

    public Reservation() {
        this.id              = compteur++;
        this.dateReservation = LocalDate.now();
        this.statut          = Statut.EN_ATTENTE;
        this.prixTotal       = 0.0;
    }

    public Reservation(Client client, Hebergement hebergement,
                       LocalDate dateArrivee, LocalDate dateDepart) {
        this.id              = compteur++;
        this.client          = client;
        this.hebergement     = hebergement;
        this.dateArrivee     = dateArrivee;
        this.dateDepart      = dateDepart;
        this.dateReservation = LocalDate.now();
        this.statut          = Statut.EN_ATTENTE;
        calculerPrixTotal();
    }

    public Reservation(Reservation r) {
        this.id              = compteur++;  // nouvel ID unique
        this.client          = r.client;
        this.hebergement     = r.hebergement;
        this.dateArrivee     = r.dateArrivee;
        this.dateDepart      = r.dateDepart;
        this.dateReservation = LocalDate.now();
        this.statut          = Statut.EN_ATTENTE;
        this.prixTotal       = r.prixTotal;
    }

    public int        getId()              { return id; }
    public Client     getClient()          { return client; }
    public Hebergement getHebergement()    { return hebergement; }
    public LocalDate  getDateArrivee()     { return dateArrivee; }
    public LocalDate  getDateDepart()      { return dateDepart; }
    public double     getPrixTotal()       { return prixTotal; }
    public Statut     getStatut()          { return statut; }

    public long getNombreNuits() {
        return ChronoUnit.DAYS.between(dateArrivee, dateDepart);
    }

    public void calculerPrixTotal() {
        int nuits = (int) getNombreNuits();
        prixTotal = hebergement.calculerPrix(nuits);
        double reduction = client.calculerReduction();
        if (reduction > 0) {
            prixTotal *= (1.0 - reduction);
        }
    }

    public void confirmer() { statut = Statut.CONFIRMEE; }
    public void annuler()   { statut = Statut.ANNULEE; }

    public boolean estEnCours() {
        LocalDate today = LocalDate.now();
        return statut == Statut.CONFIRMEE
                && !today.isBefore(dateArrivee)
                && !today.isAfter(dateDepart);
    }

    public void afficherDetails() {
        System.out.println("------ Réservation #" + id + " ------");
        System.out.println("  Client      : " + client.getNom() + " " + client.getPrenom());
        System.out.println("  Hébergement : " + hebergement.getNom());
        System.out.println("  Arrivée     : " + dateArrivee);
        System.out.println("  Départ      : " + dateDepart);
        System.out.println("  Nuits       : " + getNombreNuits());
        System.out.printf( "  Prix total  : %.2f €%n", prixTotal);
        System.out.println("  Statut      : " + statut);
    }
}