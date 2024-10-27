import java.util.Scanner;

public class Oblig7 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Programmet trenger et filnavn!");
            System.exit(1);
        }

        String filnavn = args[0];
        Labyrint lab = new Labyrint(filnavn);

        Scanner terminal = new Scanner(System.in);
        while(true) {
            System.out.println("Oppgi <rad> <kolonne> ('a' for aa avslutte)");
            String svar = terminal.nextLine();
            if (svar.equals("a")) {
                break;
            }
            try {
                int rad = Integer.parseInt(svar.split(" ")[0]);
                int kol = Integer.parseInt(svar.split(" ")[1]);
                lab.finnUtveiFra(rad, kol);
            } catch (Exception e) {
                System.out.println("ERROR!");
                System.out.println("Oppgi f.eks. '0 3' for rad 0 og kolonne 3");
            }
            System.out.println();
        }
        terminal.close();
    }
}
