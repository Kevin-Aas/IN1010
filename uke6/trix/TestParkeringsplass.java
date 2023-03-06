public class TestParkeringsplass {
    
    public static void main(String[] args) {

        Parkeringsplass<Bil> bilParkeringsplass = new Parkeringsplass<>();
        Parkeringsplass<Motorsykkel> motorsykkelPlass = new Parkeringsplass<>();

        bilParkeringsplass.parker(new Bil("AB12345", 5));
        motorsykkelPlass.parker(new Motorsykkel("BA54321", 5));

        // Disse gir feilmelding:
        // bilParkeringsplass.parker(new Motorsykkel("BA54321", 5));
        // motorsykkelPlass.parker(new Bil("AB12345", 5));

    }
}
