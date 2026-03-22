import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public abstract class Hebergement {

    private int id;
    private String nom;
    private String adresse;
    private String description;

    protected int capaciteMax;
    protected double prixParNuit;

    private List<Periode> disponibilites;

    public Hebergement() {
        this.id          = 0;
        this.nom         = "Inconnu";
        this.adresse     = "Inconnue";
        this.description = "";
        this.capaciteMax = 1;
        this.prixParNuit = 0.0;
        this.disponibilites = new ArrayList<>();
    }

    public Hebergement(int id, String nom, String adresse,
                       int capaciteMax, double prixParNuit,
                       String description) {
        this.id          = id;
        this.nom         = nom;
        this.adresse     = adresse;
        this.capaciteMax = capaciteMax;
        this.prixParNuit = prixParNuit;
        this.description = description;
        this.disponibilites = new ArrayList<>();
    }

    public Hebergement(Hebergement h) {
        this.id           = h.id;
        this.nom          = h.nom;
        this.adresse      = h.adresse;
        this.capaciteMax  = h.capaciteMax;
        this.prixParNuit  = h.prixParNuit;
        this.description  = h.description;
        this.disponibilites = new ArrayList<>(h.disponibilites);
    }

    public int getId()             { return id; }
    public String getNom()         { return nom; }
    public String getAdresse()     { return adresse; }
    public String getDescription() { return description; }
    public double getPrixParNuit() { return prixParNuit; }

    public abstract double calculerPrix(int nombreNuits);

    public void ajouterDisponibilite(LocalDate debut, LocalDate fin) {
        disponibilites.add(new Periode(debut, fin));
    }

    public boolean estDisponible(LocalDate debut, LocalDate fin) {
        for (Periode p : disponibilites) {
            if (!debut.isAfter(p.fin) && !fin.isBefore(p.debut)) {
                return true;
            }
        }
        return false;
    }

    public void afficher() {
        System.out.println("  ID          : " + id);
        System.out.println("  Nom         : " + nom);
        System.out.println("  Adresse     : " + adresse);
        System.out.println("  Capacité    : " + capaciteMax + " pers.");
        System.out.println("  Prix/nuit   : " + prixParNuit + " €");
        System.out.println("  Description : " + description);
    }

    protected static class Periode {
        LocalDate debut;
        LocalDate fin;

        public Periode(LocalDate debut, LocalDate fin) {
            this.debut = debut;
            this.fin   = fin;
        }
    }
}