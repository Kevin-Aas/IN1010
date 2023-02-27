public class BlaaResept extends Resept {
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
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
