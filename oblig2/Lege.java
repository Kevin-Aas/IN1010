public class Lege {
    public final String navn;

    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentLegeNavn() {
        return navn;
    }

    public String toString() {
        return "--------------------------\n" +
               "Navn: " + navn + "\n" +
               "--------------------------";
    }
}
