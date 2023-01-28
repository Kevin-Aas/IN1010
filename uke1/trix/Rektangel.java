class Rektangel {

    double lengde;
    double bredde;

    public Rektangel (double l, double b) {
        lengde = l;
        bredde = b;
    }

    public void oekLengde (int okning) {
        lengde += okning;
    }

    public void oekBredde (int okning) {
        bredde += okning;
    }

    public void redLengde (int reduksjon) {
        lengde -= reduksjon;
    }

    public void redBredde (int reduksjon) {
        bredde -= reduksjon;
    }

    public double areal () {
        return lengde * bredde;
    }

    public double omkrets () {
        return 2*lengde + 2*bredde;
    }
}