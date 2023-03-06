public class Sirkel extends Figur{
    double radius;

    public Sirkel(double radius){
        this.radius = radius;
        this.areal = 3.14159265359 * radius * radius;
    }
}