import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Oblig5Hele {
    
    public static void main(String[] args) {
        // Passer paa at det er oppgitt en mappe:
        if (args.length != 1) {
            System.out.println("Trenger en mappe!");
            System.exit(1);
        }

        Scanner metadataleser = null;
        // Prover aa aapne metadata.csv i den oppgitte mappen:
        try {
            metadataleser = new Scanner(new File(args[0] + "/metadata.csv"));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        // Setter opp monitorer for personer som ikke har hatt virus (frisk)
        // og for personer som har hatt virus (smittet):
        Monitor2 friskMonitor = new Monitor2();
        Monitor2 smittetMonitor = new Monitor2();

        ArrayList<Thread> traadListe = new ArrayList<>();

        // Gaar igjennom hver fil (person):
        while (metadataleser.hasNextLine()) {
            String[] linje = metadataleser.nextLine().split(",");
            String filnavn = args[0] + "/" + linje[0];
            if (linje[1].equals("False")) {
                // Har ikke hatt virus (frisk)
                Thread traad = new Thread(new LeseTrad(filnavn, friskMonitor));
                traad.start();
                traadListe.add(traad);
            } 
            else if (linje[1].equals("True")) {
                // Har hatt virus (smittet)
                Thread traad = new Thread(new LeseTrad(filnavn, smittetMonitor));
                traad.start();
                traadListe.add(traad);
            }
        }

        // Venter til lesetraadene er ferdige:
        for (Thread traad : traadListe) {
            try {
                traad.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        // Setter opp og starter flettetraader for friske og smittet:
        int antallFletteTraader = 8;
        Thread[] friskFletteTraader = new Thread[antallFletteTraader];
        Thread[] smittetFletteTraader = new Thread[antallFletteTraader];
        for (int i=0; i<antallFletteTraader; i++) {
            friskFletteTraader[i] = new Thread(new FletteTrad(friskMonitor));
            friskFletteTraader[i].start();
        }
        for (int i=0; i<antallFletteTraader; i++) {
            smittetFletteTraader[i] = new Thread(new FletteTrad(smittetMonitor));
            smittetFletteTraader[i].start();
        }

        // Venter til flettetraadene er ferdige:
        for (Thread traad : friskFletteTraader) {
            try {
                traad.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        for (Thread traad : smittetFletteTraader) {
            try {
                traad.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        
        ArrayList<Subsekvens> subsekvenser = new ArrayList<>();
        int minst = 7;
        // Gaar igjennom alle subsekvenser for de som var smittet:
        for (Subsekvens smittetS : smittetMonitor.register.beholder.get(0).values()) {
            // Sjekker om disse finnes hos de som ikke var smittet:
            if (friskMonitor.register.beholder.get(0).containsKey(smittetS.subsekvens) == false) {
                if (smittetS.hentAntall() >= minst) {
                    subsekvenser.add(smittetS);
                }
            } else {
                // Finner tilsvarende subsekvens i den friske beholderen:
                Subsekvens friskS = friskMonitor.register.beholder.get(0).get(smittetS.subsekvens);
                // Beregner avviket og legge til i arraylisten hvis storre enn tallet "minst":
                int antallFlere = smittetS.hentAntall() - friskS.hentAntall();
                if (antallFlere >= minst) {
                    subsekvenser.add(smittetS);
                }
            }
        }
        // Printer ut de som har hoye forekomster:
        System.out.println("Subsekvenser som forekommer minst "+minst+" flere ganger:");
        for (Subsekvens s : subsekvenser) {
            System.out.println(s);
        }
    }
}
