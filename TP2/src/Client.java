import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Client {

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    protected LocalDate        dateInscription;
    protected List<Reservation> reservations;

    public Client() {
        this.nom            = "Inconnu";
        this.prenom         = "Inconnu";
        this.email          = "";
        this.motDePasse     = "";
        this.dateInscription = LocalDate.now();
        this.reservations   = new ArrayList<>();
    }

    public Client(String nom, String prenom,
                  String email, String motDePasse) {
        this.nom            = nom;
        this.prenom         = prenom;
        this.email          = email;
        this.motDePasse     = motDePasse;
        this.dateInscription = LocalDate.now();
        this.reservations   = new ArrayList<>();
    }

    public Client(Client c) {
        this.nom            = c.nom;
        this.prenom         = c.prenom;
        this.email          = c.email;
        this.motDePasse     = c.motDePasse;
        this.dateInscription = c.dateInscription;
        this.reservations   = new ArrayList<>(c.reservations);
    }

    public String getNom()      { return nom; }
    public String getPrenom()   { return prenom; }
    public String getEmail()    { return email; }

    protected String getMotDePasse() { return motDePasse; }

    public abstract double calculerReduction();

    public void ajouterReservation(Reservation r) {
        reservations.add(r);
    }

    public void afficherHistorique() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation.");
            return;
        }
        for (Reservation r : reservations) {
            r.afficherDetails();
        }
    }

    public boolean seConnecter(String email, String motDePasse) {
        return this.email.equals(email)
                && this.motDePasse.equals(motDePasse);
    }

    public void afficher() {
        System.out.println("  Nom         : " + nom + " " + prenom);
        System.out.println("  Email       : " + email);
        System.out.println("  Inscription : " + dateInscription);
        System.out.println("  Réservations: " + reservations.size());
    }
}
