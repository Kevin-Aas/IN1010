import java.util.Scanner;

class Handletur {
    public static void main(String[] args){
        int antBroed = 0;
        int antMelk = 0;
        int antOst = 0;
        int antYoughurt = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hei! Velkommen til Coop.");

        System.out.print("Hvor mange brød vil du ha? ");
        antBroed += scanner.nextInt();

        System.out.print("Hvor mange melk vil du ha? ");
        antMelk += scanner.nextInt();

        System.out.print("Hvor mange ost vil du ha? ");
        antOst += scanner.nextInt();

        System.out.print("Hvor mange yoghurt vil du ha? ");
        antYoughurt += scanner.nextInt();

        int totalPris = antBroed*20 + antMelk*15 + antOst*40 + antYoughurt*12;
        System.out.println("Du skal betale: " + totalPris + " kr.");
        
        scanner.close();
    }
}