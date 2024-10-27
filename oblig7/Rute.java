abstract class Rute {
    Labyrint lab;
    int radNr, kolNr;
    Rute[] naboer = new Rute[4];   // [nord,syd,vest,oest]
    
    public Rute(Labyrint lab, int radNr, int kolNr) {
        this.lab = lab;
        this.radNr = radNr;
        this.kolNr = kolNr;
    }

    public void settNaboer(Rute n, Rute s, Rute v, Rute oe) {
        naboer[0] = n;
        naboer[1] = s;
        naboer[2] = v;
        naboer[3] = oe;
    }

    public void finn(Rute fra) {}

}
