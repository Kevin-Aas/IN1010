public class Kvadrat extends Figur{
    double sidelinje;

    public Kvadrat(double sidelinje){
        this.sidelinje = sidelinje;
        this.areal = sidelinje * sidelinje;
    }
}