public class AncienClient extends Client {

    public AncienClient(String nom, String prenom,
                        String email, String motDePasse) {

        super(nom, prenom, email, motDePasse);
    }

    @Override
    public boolean aReduction() {
        return reservations.size() >= 3;
    }

    public void accederHistorique(String email, String motDePasse) {

        if (seConnecter(email, motDePasse)) {
            System.out.println("Connexion réussie !");
            afficherHistorique();
        } else {
            System.out.println("Identifiants incorrects.");
        }
    }
}