public class HvitRute extends Rute {
    public HvitRute(Labyrint lab, int radNr, int kolNr) {
        super(lab, radNr, kolNr);
    }

    @Override
    public String toString() {
        return ".";
    }

    public void finn(Rute fra) {
        if (fra == null) {
            for (Rute r : naboer) {
                r.finn(this);
            }
        } else {
            for (Rute r : naboer) {
                // Vi gaar ikke tilbake til fra-ruten:
                if (r != fra) {
                    r.finn(this);
                }
            }
        }
    }
}
