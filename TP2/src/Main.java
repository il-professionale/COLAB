import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Constructeurs par défaut ---");
        Hotel hotelDefaut = new Hotel();
        hotelDefaut.afficher();

        NouveauClient ncDefaut = new NouveauClient();
        ncDefaut.afficher();

        System.out.println("\n--- Constructeurs avec paramètres ---");

        Hotel h1 = new Hotel(
                1, "Hotel SARACENO", "Paris",
                2, 100.0, "Centre ville",
                4, "Gastronomique");
        h1.ajouterDisponibilite(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 12, 31));
        h1.afficher();
        System.out.println("  Prestations : " + h1.getPrestations());

        Appartement apt1 = new Appartement(
                2, "Appart Montmartre", "Paris 18e",
                4, 80.0, "Vue panoramique",
                65.0, 3);
        apt1.afficher();

        NouveauClient nc = new NouveauClient(
                "Dupont", "Alice",
                "alice@mail.com", "motDePasse",
                "PROMO2026");
        nc.afficher();

        AncienClient ac = new AncienClient(
                "Martin", "Bob",
                "bob@mail.com", "BobMarley",
                350);  // 350 points → niveau Silver
        ac.afficher();

        System.out.println("\n--- Constructeurs par copie ---");

        Hotel h1Copie = new Hotel(h1);
        System.out.println("Copie de l'hôtel : " + h1Copie.getNom()
                + " — " + h1Copie.getNombreEtoiles() + "★");

        AncienClient acCopie = new AncienClient(ac);
        System.out.println("Copie de l'ancien client : "
                + acCopie.getNom() + " " + acCopie.getPrenom());

        System.out.println("\n--- Réservations ---");

        Reservation r1 = new Reservation(
                nc, h1,
                LocalDate.of(2026, 5, 1),
                LocalDate.of(2026, 5, 5)); // 4 nuits
        r1.confirmer();
        nc.ajouterReservation(r1);
        r1.afficherDetails();

        Reservation r2 = new Reservation(ac, h1,
                LocalDate.of(2026, 2, 1), LocalDate.of(2026, 2, 3));
        Reservation r3 = new Reservation(ac, apt1,
                LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 7));
        Reservation r4 = new Reservation(ac, h1,
                LocalDate.of(2026, 6, 1), LocalDate.of(2026, 6, 6));
        r2.confirmer(); ac.ajouterReservation(r2);
        r3.confirmer(); ac.ajouterReservation(r3);
        r4.confirmer(); ac.ajouterReservation(r4);
        r4.afficherDetails();
        System.out.printf("Réduction appliquée : %.0f%%%n",
                ac.calculerReduction() * 100);

        System.out.println("\n--- Appartement séjour long ---");
        Reservation r5 = new Reservation(nc, apt1,
                LocalDate.of(2026, 7, 1), LocalDate.of(2026, 7, 10));
        r5.confirmer();
        nc.ajouterReservation(r5);
        r5.afficherDetails();

        System.out.println("\n--- Historique AncienClient ---");
        ac.accederHistorique("bob@mail.com", "BobMarley");

        System.out.println("\n--- Copie d'une réservation ---");
        Reservation r1Copie = new Reservation(r1);
        r1Copie.afficherDetails();
    }
}