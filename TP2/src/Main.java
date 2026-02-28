import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Hebergement h1 = new Hebergement(
                1, "Hotel SARACENO", "Paris",
                "Hotel", 2, 100,
                "Centre ville");

        h1.ajouterDisponibilite(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 12, 31));

        // Nouveau client
        NouveauClient nc = new NouveauClient(
                "Dupont", "Alice",
                "alice@mail.com", "motDePasse");

        Reservation r1 = new Reservation(
                nc, h1,
                LocalDate.of(2026, 5, 1),
                LocalDate.of(2026, 5, 5));

        r1.confirmer();
        nc.ajouterReservation(r1);

        // Ancien client
        AncienClient ac = new AncienClient(
                "Martin", "Bob",
                "bob@mail.com", "BobMarlei");

        Reservation r2 = new Reservation(
                ac, h1,
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 6));

        r2.confirmer();
        ac.ajouterReservation(r2);

        ac.accederHistorique("bob@mail.com", "BobMarlei");
    }
}