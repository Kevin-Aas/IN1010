public class SvartRute extends Rute {
    public SvartRute(Labyrint lab, int radNr, int kolNr) {
        super(lab, radNr, kolNr);
    }

    @Override
    public String toString() {
        return "#";
    }

    public void finn(Rute fra) {
        if (fra == null) {
            System.out.println("(valgte en svart rute)");
        }
    }
}
