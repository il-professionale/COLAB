import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hebergement {

    private int id;
    private String nom;
    private String adresse;
    private String type;
    private int capaciteMax;
    private double prixParNuit;
    private String description;

    private List<Periode> disponibilites;

    public Hebergement(int id, String nom, String adresse,
                       String type, int capaciteMax,
                       double prixParNuit, String description) {

        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.capaciteMax = capaciteMax;
        this.prixParNuit = prixParNuit;
        this.description = description;

        this.disponibilites = new ArrayList<>();
    }

    public String getNom() { return nom; }
    public String getType() { return type; }
    public double getPrixParNuit() { return prixParNuit; }

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

    private class Periode {
        private LocalDate debut;
        private LocalDate fin;

        public Periode(LocalDate debut, LocalDate fin) {
            this.debut = debut;
            this.fin = fin;
        }
    }
}