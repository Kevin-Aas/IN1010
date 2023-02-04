import java.util.Scanner;

class GameOfLife {
    
    public static void main(String[] args) {
        System.out.println("################# Game Of Life #################");

        Scanner scanner = new Scanner(System.in);
        System.out.println("'Vennligst oppgi antall rader og kolonner'");
        System.out.print("Rader: ");
        int rader = scanner.nextInt();
        System.out.print("Kolonner: ");
        int kolonner = scanner.nextInt();

        Verden verden = new Verden(rader, kolonner);
        verden.tegn();

        boolean fortsett = true;
        String svar;
        while (fortsett){
            System.out.print("'Vil du forsette?' [ja/nei] ");
            svar = scanner.next();
            if (svar.equals("nei")){
                System.out.println("'Progammet avsluttet'");
                fortsett = false;
            } else if (svar.equals("ja")){
                verden.oppdatering();
                verden.tegn();
            }
        }
        scanner.close();
    }
}