public class Modell {
    Verden verden;

    public Modell (int rader, int kolonner) {
        verden = new Verden(rader, kolonner);
    }

    public void lesGUIRutenett(boolean[][] guiRutenett) {
        verden.lesRutenett(guiRutenett); // Leser rutenettet
        verden.oppdatering();   // Oppdaterer alle cellene
    }

    public boolean[][] hentModellRutenett() {
        return verden.hentRutenett();
    }
}
