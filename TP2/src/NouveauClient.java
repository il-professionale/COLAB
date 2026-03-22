import java.time.LocalDate;

public class NouveauClient extends Client {

    private String    codeParrainage;
    private LocalDate dateCreation;

    public NouveauClient() {
        super();
        this.codeParrainage = "AUCUN";
        this.dateCreation   = LocalDate.now();
        System.out.println("Inscription réussie !");
    }

    public NouveauClient(String nom, String prenom,
                         String email, String motDePasse,
                         String codeParrainage) {
        super(nom, prenom, email, motDePasse);
        this.codeParrainage = codeParrainage;
        this.dateCreation   = LocalDate.now();
        System.out.println("Inscription réussie !");
    }

    public NouveauClient(NouveauClient c) {
        super(c); // copie les attributs de Client via super
        this.codeParrainage = c.codeParrainage;
        this.dateCreation   = c.dateCreation;
    }

    public String    getCodeParrainage() { return codeParrainage; }
    public LocalDate getDateCreation()   { return dateCreation; }

    @Override
    public double calculerReduction() {
        return 0.0;
    }

    @Override
    public void afficher() {
        System.out.println("------ Client : Nouveau Client ------");
        super.afficher();
        System.out.println("  Code parrainage : " + codeParrainage);
        System.out.println("  Créé le         : " + dateCreation);
    }
}