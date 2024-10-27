public class Katt implements Comparable<Katt>{
    private String navn;
    private int alder;

    public Katt(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public String hentNavn() {
        return navn;
    }

    public int hentAlder() {
        return alder;
    }

    public int compareTo(Katt nyKatt) {
        if (alder < nyKatt.hentAlder()) {
            return -1;
        } else if (alder > nyKatt.hentAlder()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Navn: "+navn + " -- Alder: " + alder + " år";
    }
}
