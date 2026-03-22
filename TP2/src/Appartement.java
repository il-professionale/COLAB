public class Appartement extends Hebergement {

    private double superficie;
    private int    nbPieces;

    public Appartement() {
        super();
        this.superficie = 20.0;
        this.nbPieces   = 1;
    }

    public Appartement(int id, String nom, String adresse,
                       int capaciteMax, double prixParNuit, String description,
                       double superficie, int nbPieces) {
        super(id, nom, adresse, capaciteMax, prixParNuit, description);
        this.superficie = superficie;
        this.nbPieces   = nbPieces;
    }

    public Appartement(Appartement a) {
        super(a);
        this.superficie = a.superficie;
        this.nbPieces   = a.nbPieces;
    }

    public double getSuperficie() { return superficie; }
    public int    getNbPieces()   { return nbPieces; }

    @Override
    public double calculerPrix(int nombreNuits) {
        double base = prixParNuit * nombreNuits;
        return (nombreNuits >= 7) ? base * 0.9 : base;
    }

    @Override
    public void afficher() {
        System.out.println("------ Hébergement : Appartement ------");
        super.afficher();
        System.out.println("  Superficie  : " + superficie + " m²");
        System.out.println("  Nb pièces   : " + nbPieces);
    }
}
