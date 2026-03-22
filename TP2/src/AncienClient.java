public class AncienClient extends Client {

    private int    pointsFidelite;
    private String niveauFidelite; // "Bronze", "Silver", "Gold"

    public AncienClient() {
        super();
        this.pointsFidelite = 0;
        this.niveauFidelite = "Bronze";
    }

    public AncienClient(String nom, String prenom,
                        String email, String motDePasse,
                        int pointsFidelite) {
        super(nom, prenom, email, motDePasse);
        this.pointsFidelite = pointsFidelite;
        this.niveauFidelite = calculerNiveau(pointsFidelite);
    }

    public AncienClient(AncienClient c) {
        super(c);
        this.pointsFidelite = c.pointsFidelite;
        this.niveauFidelite = c.niveauFidelite;
    }

    public int    getPointsFidelite() { return pointsFidelite; }
    public String getNiveauFidelite() { return niveauFidelite; }

    @Override
    public double calculerReduction() {
        if (reservations.size() >= 3 && niveauFidelite.equals("Gold")) {
            return 0.20;
        } else if (reservations.size() >= 3) {
            return 0.10;
        }
        return 0.0;
    }

    public void accederHistorique(String email, String motDePasse) {
        if (seConnecter(email, motDePasse)) {
            System.out.println("Connexion réussie !");
            afficherHistorique();
        } else {
            System.out.println("Identifiants incorrects.");
        }
    }

    public void ajouterPoints(int points) {
        this.pointsFidelite += points;
        this.niveauFidelite  = calculerNiveau(this.pointsFidelite);
    }

    @Override
    public void afficher() {
        System.out.println("------ Client : Ancien Client ------");
        super.afficher();
        System.out.println("  Points fidélité : " + pointsFidelite);
        System.out.println("  Niveau          : " + niveauFidelite);
        System.out.printf( "  Réduction droit : %.0f%%%n", calculerReduction() * 100);
    }

    private String calculerNiveau(int points) {
        if (points >= 500) return "Gold";
        if (points >= 200) return "Silver";
        return "Bronze";
    }
}