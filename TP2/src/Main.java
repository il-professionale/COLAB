import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Hebergement h1 = new Hebergement(
                1,
                "Hotel Paris",
                "Paris",
                "Hotel",
                2,
                100,
                "Centre ville"
        );

        h1.ajouterDisponibilite(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 12, 31)
        );

        Client c1 = new Client(
                "Dupont",
                "Alice",
                "alice@mail.com",
                "Paris"
        );

        c1.reserver(
                h1,
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 15),
                5
        );

        c1.afficherInfos();
    }
}