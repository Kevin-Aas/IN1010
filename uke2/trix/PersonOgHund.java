import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class PersonOgHund {
    public static void main(String[] args){

        ArrayList<Person2> personer = new ArrayList<Person2>();
        ArrayList<Hund2> hunder = new ArrayList<Hund2>();

        Scanner filLeser = null;
        try {
            filLeser = new Scanner(new File("navn.txt"));
        } catch (Exception e){
            System.out.println("Klarte ikke å lese fil");
            System.exit(0);
        }

        while (filLeser.hasNextLine()){
            String[] linje = filLeser.nextLine().split(" ");
            String art = linje[0];
            String navn = "";
            for (int i=1; i<linje.length; i++){
                navn += linje[i] + " ";
            }
            if (art.equals("P")){
                personer.add(new Person2(navn));
            } else if (art.equals("H")){
                hunder.add(new Hund2(navn));
            }
        }
        filLeser.close();

        System.out.println("**Personer**");
        for (Person2 person : personer){
            System.out.println(person.hentNavn());
        }

        System.out.println("**Hunder**");
        for (Hund2 hund : hunder){
            System.out.println(hund.hentNavn());
        }
    }
}
