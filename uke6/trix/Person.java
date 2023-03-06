public class Person {
    private String navn;
    private String gjenstand;
    private Person neste;

    public Person(String navn, String gjenstand) {
        this.navn = navn;
        this.gjenstand = gjenstand;
    }

    public void settNeste(Person neste) {
        this.neste = neste;
    }

    public Person hentNeste() {
        return neste;
    }

    public String hentNavn() {
        return navn;
    }

    public String hentGjenstand() {
        return gjenstand;
    }
}
