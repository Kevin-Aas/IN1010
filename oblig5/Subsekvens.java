public class Subsekvens {
    public final String subsekvens;
    private int antall;

    public Subsekvens(String subsekvens) {
        this.subsekvens = subsekvens;
    }

    public int hentAntall() {
        return antall;
    }

    public void endreAntall(int tall) {
        antall += tall;
    }

    @Override
    public String toString() {
        return "(" + subsekvens + "," + antall + ")";
    }
}