public class Trekant extends Figur{
    double grunnlinje;
    double høyde;

    public Trekant(double grunnlinje, double høyde){
        this.grunnlinje = grunnlinje;
        this.høyde = høyde;
        this.areal = (grunnlinje * høyde)/2;
    }
}