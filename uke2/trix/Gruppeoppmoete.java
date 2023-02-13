import java.util.Scanner;
import java.io.File;

class Gruppeoppmoete {
    private String[] navn = new String[14];
    private boolean[] oppmoete = new boolean[14];

    public void lesOgFyllNavn(){
        Scanner filLeser = null;
        try {
            filLeser = new Scanner(new File("gruppeliste.txt"));
        } catch (Exception e){
            System.out.println("Klarte ikke å lese fil");
            System.exit(0);
        }

        for (int i=0; i<navn.length; i++){
            String navnFraListe = filLeser.nextLine();
            navn[i] = navnFraListe;
        }
        filLeser.close();
    }

    public void fyllOppmoete(){
        for (int i=0; i<oppmoete.length; i++){
            if (Math.random() < 0.33){
                oppmoete[i] = false;                
            } else {
                oppmoete[i] = true;
            }
        }
    }

    public void skrivUtStudenter(){
        System.out.printf("%-20s %10s", "Navn", "Oppmøte");
        System.out.println();
        for (int i=0; i<navn.length; i++){
            System.out.printf("%-20s %10s", navn[i], oppmoete[i]);
            System.out.println();
        }
    }
}