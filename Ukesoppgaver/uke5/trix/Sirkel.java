public class Sirkel implements Figur {
    
    private double radius;

    public Sirkel(double radius) {
        this.radius = radius;
    }

    public double beregnAreal() {
        return 3.1415 * radius * radius;
    }

    public double beregnOmkrets() {
        return 2 * radius * 3.1415;
    }
}