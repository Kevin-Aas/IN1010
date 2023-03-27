public class PResept extends HvitResept {
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    public int prisAaBetale() {
        int orginalPris = legemiddel.hentPris();
        if (orginalPris <= 108) {
            return 0;
        } else {
            return orginalPris - 108;
        }
    }
}
