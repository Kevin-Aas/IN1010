public class PResept extends HvitResept {
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
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
