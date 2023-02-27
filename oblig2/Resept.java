public abstract class Resept {
    private static int antResepter;
    public final int id;
    public final Legemiddel legemiddel;
    public final Lege utskrivendeLege;
    public final int pasientId;
    public int reit;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        if (legemiddel instanceof Narkotisk && !(utskrivendeLege instanceof Spesialist)) {
            System.out.println("**Vanlig lege kan ikke skrive ut resept for narkotiske legemidler**");
            System.exit(0);
            // 'Kom ikke paa noen bedre maate aa implementer spesialister paa'
        }
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        id = antResepter;
        antResepter++;
    }

    // Hente metoder:
    public int hentId() {
        return id;
    }
    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }
    public Lege hentLege() {
        return utskrivendeLege;
    }
    public int hentPasientId() {
        return pasientId;
    }
    public int hentReit() {
        return reit;
    }

    // Anvendelige metoder:
    public boolean bruk() {
        if (reit == 0) {
            return false;
        } else {
            reit--;
            return true;
        }
    }
    abstract public String farge();
    abstract public int prisAaBetale();

    public String toString() {
        return "--------------------------\n" +
               "Id: " + id + "\n" +
               "Legemiddel: " + legemiddel.navn + "\n" +
               "Lege: " + utskrivendeLege.hentLegeNavn() + "\n" +
               "PasientId: " + pasientId + "\n" +
               "Reit: " + reit + "\n" +
               "--------------------------";
    }
}
