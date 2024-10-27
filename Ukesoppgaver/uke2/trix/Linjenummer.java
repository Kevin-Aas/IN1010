import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Linjenummer {
    public static void main(String[] args) throws FileNotFoundException{
        // Oppretter en scanner for tekstfilen:
        File fil = new File("tekst2.txt");
        Scanner filLeser = new Scanner(fil);

        int teller = 0;
        while (filLeser.hasNextLine()){
            teller++;
            String linje = filLeser.nextLine(); // Leser av neste linje i tekstfilen
            System.out.println("# " + teller + ": " + linje);
        }
        filLeser.close();
    }
}