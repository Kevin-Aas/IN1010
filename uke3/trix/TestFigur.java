public class TestFigur{
    public static void main(String[] args){
        Figur[] figurer = {new Trekant(2, 3),
                           new Sirkel(3),
                           new Rektangel(3, 7),
                           new Kvadrat(4)};

        double totalAreal = 0;
        for (Figur figur : figurer){
            totalAreal += figur.hentAreal();
        }

        System.out.println("Totalt areal: " + totalAreal);
    }
}