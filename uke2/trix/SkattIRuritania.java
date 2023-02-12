import java.util.Scanner;

class SkattIRuritania {
    public static void main(String[] args){
        // Oppretter et scanner objekt for aa lese fra terminalen
        Scanner scanner = new Scanner(System.in);

        System.out.print("Oppgi inntekt (kr): ");
        double inntekt = scanner.nextDouble();

        double skatt;
        if (inntekt < 10000){
            skatt = inntekt * 0.10;
            System.out.println("Beregnet skatt: " + skatt + ",-");
        } else {
            skatt = (10000 * 0.10) + ((inntekt-10000) * 0.30);
            System.out.println("Beregnet skatt: " + skatt + ",-");
        }
        scanner.close();
    }
}