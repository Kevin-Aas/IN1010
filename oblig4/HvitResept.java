public class HvitResept extends Resept {
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    public String farge() {
        return "hvit";
    }

    public int prisAaBetale() {
        int orginalPris = legemiddel.hentPris();
        return orginalPris;
    }

}
