public class NouveauClient extends Client {

    public NouveauClient(String nom, String prenom,
                         String email, String motDePasse) {

        super(nom, prenom, email, motDePasse);
        System.out.println("Inscription réussie !");
    }

    @Override
    public boolean aReduction() {
        return false; // jamais de réduction
    }
}
