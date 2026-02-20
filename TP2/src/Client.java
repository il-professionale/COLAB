import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private LocalDate dateInscription;
    private int pointsFidelite;

    private List<Reservation> reservations;

    public Client(String nom, String prenom,
                  String email, String adresse) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.dateInscription = LocalDate.now();
        this.pointsFidelite = 0;
        this.reservations = new ArrayList<>();
    }

    // Filtrer hébergements
    public List<Hebergement> filtrer(List<Hebergement> liste,
                                     String type,
                                     double prixMax) {

        List<Hebergement> resultat = new ArrayList<>();

        for (Hebergement h : liste) {
            if (h.getType().equalsIgnoreCase(type)
                    && h.getPrixParNuit() <= prixMax) {

                resultat.add(h);
            }
        }
        return resultat;
    }

    // Réserver
    public void reserver(Hebergement h,
                         LocalDate debut,
                         LocalDate fin,
                         int nbNuits) {

        if (h.estDisponible(debut, fin)) {

            double prix = h.calculerPrixTotal(nbNuits);

            if (pointsFidelite >= 100) {
                prix *= 0.9; // 10% réduction
            }

            Reservation r = new Reservation(h, debut, fin, prix);
            reservations.add(r);
            pointsFidelite += 10;

            System.out.println("Réservation confirmée !");
        } else {
            System.out.println("Non disponible.");
        }
    }

    public void afficherInfos() {
        System.out.println(prenom + " " + nom);
        System.out.println("Email : " + email);
        System.out.println("Points fidélité : " + pointsFidelite);
    }
}

