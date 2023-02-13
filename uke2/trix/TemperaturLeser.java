import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class TemperaturLeser {
    public static void main(String[] args){
        // String-array med 12 plasser:
        String[] temperaturer = new String[12];

        // Scanner objekt for å lese "temperatur.txt":
        Scanner input = null;
        // Prøver å lese (scanne) filen:
        try {
            input = new Scanner(new File("tempertur.txt"));
        } catch (FileNotFoundException e){
            System.out.println("Klarte ikke å lese fil - " + e);
            System.exit(0);
        }

        // Legger til temperaturene fra filen over til arrayet:
        int index = 0;
        while (input.hasNextLine()){
            temperaturer[index] = input.nextLine();
            index++;
        }

        // Printer ut alle temperaturene:
        for (String temp : temperaturer){
            System.out.println(temp);
        }
    }
}