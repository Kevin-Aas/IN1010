import java.util.Scanner;

public class KoProgram {
    public static void main(String[] args){

        Scanner terminal = new Scanner(System.in);
        KoSystem koSystem = new KoSystem();

        boolean status = true;
        while (status){
            System.out.println("**MENY FOR BILLETTSYSTEM**");
            System.out.println("1 - Trekk ny kolapp.");
            System.out.println("2 - Betjen kunde.");
            System.out.println("3 - Print antall kunder i kø.");
            System.out.println("4 - Avslutt.");
            System.out.println();

            int svar = terminal.nextInt();
            switch (svar) {
                case 1:
                    koSystem.trekkKoLapp();                 
                    break;
                case 2:
                    koSystem.betjenKunde();
                    break;
                case 3:
                    koSystem.printKunderIKo();
                    break;
                case 4:
                    System.out.println("Programmet avsluttes.");
                    status = false;
                    break;            
                default:
                    break;
            }
        }

        terminal.close();
    }    
}