public class Hotel extends Hebergement {

    private int    nombreEtoiles;
    private String typeRestaurant;

    public Hotel() {
        super();
        this.nombreEtoiles  = 1;
        this.typeRestaurant = "Aucun";
    }

    public Hotel(int id, String nom, String adresse,
                 int capaciteMax, double prixParNuit, String description,
                 int nombreEtoiles, String typeRestaurant) {
        super(id, nom, adresse, capaciteMax, prixParNuit, description);
        this.nombreEtoiles  = nombreEtoiles;
        this.typeRestaurant = typeRestaurant;
    }

    public Hotel(Hotel h) {
        super(h); // copie les attributs de Hebergement via super
        this.nombreEtoiles  = h.nombreEtoiles;
        this.typeRestaurant = h.typeRestaurant;
    }

    public int    getNombreEtoiles()  { return nombreEtoiles; }
    public String getTypeRestaurant() { return typeRestaurant; }

    @Override
    public double calculerPrix(int nombreNuits) {
        double base = prixParNuit * nombreNuits;
        double majoration = (nombreEtoiles > 2) ? 1.0 + (nombreEtoiles - 2) * 0.1 : 1.0;
        return base * majoration;
    }

    @Override
    public void afficher() {
        System.out.println("------ Hébergement : Hôtel ------");
        super.afficher();
        System.out.println("  Étoiles     : " + nombreEtoiles + " ★");
        System.out.println("  Restaurant  : " + typeRestaurant);
    }

    public String getPrestations() {
        return nombreEtoiles >= 4 ? "Spa, Piscine, Conciergerie" : "Petit-déjeuner inclus";
    }
}

