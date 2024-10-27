public class Rektangel extends Figur{
    double bredde;
    double høyde;

    public Rektangel(double bredde, double høyde){
        this.bredde = bredde;
        this.høyde = høyde;
        this.areal = bredde * høyde;
    }
}