import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public class SubsekvensRegister {
    public ArrayList<HashMap<String, Subsekvens>> beholder = new ArrayList<>();

    public void settInn(HashMap<String, Subsekvens> hashmap) {
        // Setter inn forst i listen
        if (beholder.size() > 0) {
            beholder.add(0, hashmap);
        }
        else {
            beholder.add(hashmap);
        }
    }

    public HashMap<String, Subsekvens> taUt(int index) {
        if (beholder.size() < 1) {
            return null;
        } else {
            return beholder.remove(index);
        }
    }

    public int storrelse() {
        return beholder.size();
    }

    public static HashMap<String, Subsekvens> lesfil(String filnavn) {
        Scanner filleser = null;
        try {
            filleser = new Scanner(new File(filnavn));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        HashMap<String, Subsekvens> hashmap = new HashMap<>();
        //filleser.nextLine();

        while(filleser.hasNextLine()) {
            String[] linje = filleser.nextLine().split("");

            // Passer paa at linjen er storre enn 3:
            if (linje.length < 3) {
                break;
            }

            for (int i=0; i<linje.length-2; i++) {
                String triplet = linje[i] + linje[i+1] + linje[i+2];
                // Sjekker om subsekvensen allerede finnes i hashmappen:
                if (hashmap.get(triplet) == null) {
                    // Setter ny subsekvens inn i hashmap og endrer paa antallet:
                    Subsekvens subsekvens = new Subsekvens(triplet);
                    hashmap.put(triplet, subsekvens);
                    subsekvens.endreAntall(1);
                }
            }
        }
        return hashmap;
    } 

    public static HashMap<String, Subsekvens> sammenslaa(HashMap<String, Subsekvens> hashmap1, 
                                                         HashMap<String, Subsekvens> hashmap2) 
    {
        HashMap<String, Subsekvens> hashmap = hashmap1;
        // Gaar gjennom alle subsekvensene i den andre hashmappen:
        for (Subsekvens s : hashmap2.values()) {
            if (hashmap == null) {
                // Hvis den andre hashmappen er null saa lager vi en ny hashmap og legger
                // subsekvensen inn:
                hashmap = new HashMap<String, Subsekvens>();
                hashmap.put(s.subsekvens, s);
            } 
            else if (hashmap.containsKey(s.subsekvens) == false) {
                // Hvis subsekvensen ikke finnes i den andre saa legges den bare til:
                hashmap.put(s.subsekvens, s);
            } 
            else {
                // Hvis den allerde finnes saa oker vi bare antallet med en:
                hashmap.get(s.subsekvens).endreAntall(1);
            }
        }
        return hashmap;
    }
}
