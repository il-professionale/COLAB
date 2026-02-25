import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {

    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    protected LocalDate dateInscription;

    protected List<Reservation> reservations;

    public Client(String nom, String prenom,
                  String email, String motDePasse) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = LocalDate.now();
        this.reservations = new ArrayList<>();
    }

    public boolean aReduction() {
        return false;
    }

    public void ajouterReservation(Reservation r) {
        reservations.add(r);
    }

    public void afficherHistorique() {
        for (Reservation r : reservations) {
            r.afficherDetails();
        }
    }

    public boolean seConnecter(String email, String motDePasse) {
        return this.email.equals(email)
                && this.motDePasse.equals(motDePasse);
    }
}