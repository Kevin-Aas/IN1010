public class HvitResept extends Resept {
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    public String farge() {
        return "hvit";
    }

    public int prisAaBetale() {
        int orginalPris = legemiddel.hentPris();
        return orginalPris;
    }
}
