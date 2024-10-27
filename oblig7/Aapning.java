public class Aapning extends HvitRute {
    public Aapning(Labyrint lab, int radNr, int kolNr) {
        super(lab, radNr, kolNr);
    }

    @Override
    public String toString() {
        return ".";
    }

    public void finn(Rute fra) {
        // Legger til listen med aapninger som skal printes ut
        lab.leggTilAapning(radNr, kolNr);
    }
}
