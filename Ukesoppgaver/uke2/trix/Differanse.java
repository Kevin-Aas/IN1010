import java.util.Scanner;
import java.lang.Math;

class Differanse {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Oppgi verdi for x: ");
        int x = scanner.nextInt();
        System.out.print("Oppgi verdi for y: ");
        int y = scanner.nextInt();
        System.out.println("Differansen mellom x og y er " + Math.abs(x-y));
        scanner.close();
    }
}