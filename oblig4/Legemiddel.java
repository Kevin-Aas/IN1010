public abstract class Legemiddel {
    private static int antLegemider = 0; // Holder styr paa antall objekter av denne klassen
    public final String navn;
    public final int id;
    public int pris;
    public final double virkestoff;

    public Legemiddel(String navn, int pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        // Setter id-en lik 'antall objekter som er laget av denne klassen':
        id = antLegemider;
        antLegemider++;
    }

    public int hentPris() {
        return pris;
    }

    public String hentNavn() {
        return navn;
    }

    public double hentVirkestoff() {
        return virkestoff;
    }

    public void settNyPris(int nyPris) {
        pris = nyPris;
    }

    public String toString() {
        return "[Navn: "+navn+" || Pris: "+pris+" NOK"+" || Virkestoff: "+virkestoff+" mg]";
    }
}