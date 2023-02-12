import java.util.Scanner;

class Produkt {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Oppgi verdien for x: ");
        int x = scanner.nextInt();
        System.out.print("Oppgi verdien for y: ");
        int y = scanner.nextInt();
        System.out.println("Produktet av x og y er " + (x*y));

        if ((x-y) < 0){
            System.out.println("Differansen mellom x og y er negativt");
        } else {
            System.out.println("Differansen mellom x og y er positivt");
        }
        scanner.close();
    }
}