import java.util.HashMap;
import java.util.Scanner;

class Telefonbok {
    public static void main(String[] args){
        // Oppretter ny hashmapp:
        HashMap<String, String> personNummere = new HashMap<String, String>();
        
        // Legger til i hashmappen:
        personNummere.put("Arne", "22334455");
        personNummere.put("Lisa", "95959595");
        personNummere.put("Jonas", "97959795");
        personNummere.put("Peder", "12345678");

        // Oppretter et scanner objekt:
        Scanner scanner = new Scanner(System.in);

        boolean status = true;
        while (status){
            // Spør om et navn og printer ut nummeret til den personen:
            System.out.print("Oppgi navnet du ønsker nummeret til: ");
            String navn = scanner.nextLine();
            String nummer = personNummere.get(navn);
            if (nummer == null){
                System.out.println("ERROR: Denne personen finnes ikke");
            } else {
                System.out.println("Nummer: " + nummer);
            }

            // Sjekker om man vil fortsette:
            System.out.print("Vil du fortsette? [ja/nei]: ");
            String svar = scanner.nextLine();
            if (svar.equals("nei")){
                System.out.println("'Programmet avsluttes'");
                status = false;
            }
        }
        scanner.close();
    }
}