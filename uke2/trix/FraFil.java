import java.io.File;
import java.util.Scanner;

class FraFil {
    public static void main(String[] args){
        // Åpner tekstfilen:
        // (må sette Scanner variabelen utenfor try blokken)
        Scanner fraFil = null;
        try {
            File tekstFil = new File("tekst.txt");  // kan ikke gi exception      
            fraFil = new Scanner(tekstFil);         // kan gi FileNotFoundException
        } catch (Exception e) {
            System.out.println("Kan ikke lese fil");
        }
        // Går igjennom linjene i "tekst.txt" og printer dem ut:
        while (fraFil.hasNextLine()){
            String linje = fraFil.nextLine();
            System.out.println(linje);
        }
    }
}