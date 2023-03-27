public class Narkotisk extends Legemiddel{
    public final int styrke;

    public Narkotisk(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentStyrke() {
        return styrke;
    }

    public String toString() {
        return "[Navn: "+navn+" || Pris: "+pris+" NOK"
                +" || Virkestoff: "+virkestoff+" mg || Styrke: "+styrke+"]";
    }
}
