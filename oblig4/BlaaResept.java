public class BlaaResept extends Resept {
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    public String farge() {
        return "blaa";
    }

    public int prisAaBetale() {
        int orginalPris = legemiddel.hentPris();
        int nyPris = (int) Math.round(orginalPris * 0.25);
        return nyPris;
    }

}
