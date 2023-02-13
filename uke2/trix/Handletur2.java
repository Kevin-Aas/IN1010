import java.util.HashMap;
import java.util.Scanner;

class Handletur2 {
    public static void main(String[] args){
        HashMap<String, Integer> handlekurv = new HashMap<String, Integer>();
        handlekurv.put("Broed", 20);
        handlekurv.put("Melk", 15);
        handlekurv.put("Ost", 40);
        handlekurv.put("Youghurt", 12);

        Scanner scanner = new Scanner(System.in);

        for (String produkt : handlekurv.keySet()){
            System.out.print("Hvor mange " + produkt + " vil du ha? ");
            handlekurv.put(produkt, handlekurv.get(produkt) * scanner.nextInt());
        }
        int totalPris = 0;
        for (int pris : handlekurv.values()){
            totalPris += pris;
        }
        System.out.println("Du skal betale: " + totalPris + " kr.");
        scanner.close();
    }
}