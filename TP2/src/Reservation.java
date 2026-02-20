import java.time.LocalDate;

public class Reservation {

    private Hebergement hebergement;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double prixTotal;

    public Reservation(Hebergement hebergement,
                       LocalDate dateDebut,
                       LocalDate dateFin,
                       double prixTotal) {

        this.hebergement = hebergement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
    }

    public Hebergement getHebergement() {
        return hebergement;
    }

    public void afficherReservation() {
        System.out.println("Réservation pour : " + hebergement.getNom());
        System.out.println("Du " + dateDebut + " au " + dateFin);
        System.out.println("Prix total : " + prixTotal + " €");
    }
}
