import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Labyrint {
    Rute[][] ruter;
    int antRad, antKol;
    ArrayList<int[]> aapninger = new ArrayList<>(); // holder styr paa alle aapningene

    public Labyrint(String filnavn) {
        Scanner infile = null;
        try {
            infile = new Scanner(new File(filnavn));
        } catch (Exception e) {
            System.out.println("Klarte ikke aa lese filen '" + filnavn + "'");
            System.exit(1);
        }

        String[] firstLine = infile.nextLine().split(" ");
        antRad = Integer.parseInt(firstLine[0]);
        antKol = Integer.parseInt(firstLine[1]);
        ruter = new Rute[antRad][antKol];

        int rx = 0;
        while(infile.hasNextLine()) {
            String[] nextLine = infile.nextLine().split("");
            int kx = 0;
            for (String s : nextLine) {
                if (s.equals("#")) {
                    ruter[rx][kx] = new SvartRute(this, rx, kx);
                } 
                else if (s.equals(".")) {
                    // Sjekker om den hvite ruten er langs kanten:
                    if (rx == 0 || kx == 0 || rx == antRad-1 || kx == antKol-1) {
                        // Langs kanten
                        ruter[rx][kx] = new Aapning(this, rx, kx);
                    } else {
                        // Ikke langs kanten
                        ruter[rx][kx] = new HvitRute(this, rx, kx);
                    }
                }
                kx++;
            }
            rx++;
        }
        
        // Setter naboer:
        for (int i=0; i<antRad; i++) {
            for (int j=0; j<antKol; j++) {
                Rute nord, syd, vest, oest;
                // Prover aa sette naboindexene som naboer, men setter dem lik null 
                // hvis de er utenfor labyrinten:
                try {
                    nord = ruter[i-1][j];
                } catch (ArrayIndexOutOfBoundsException e) {
                    nord = null;
                }
                try {
                    syd = ruter[i+1][j];
                } catch (ArrayIndexOutOfBoundsException e) {
                    syd = null;
                }
                try {
                    vest = ruter[i][j-1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    vest = null;
                }
                try {
                    oest = ruter[i][j+1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    oest = null;
                }
                ruter[i][j].settNaboer(nord, syd, vest, oest);
            }
        }
        System.out.println("\nSlik ser labrinten ut:\n");
        System.out.println(this);
    }

    public void finnUtveiFra(int rad, int kol) {
        ruter[rad][kol].finn(null);
        // Printer ut alle aapningene (hvis det er noen):
        if (aapninger.size() == 0) {
            System.out.println("Finnes ingen aapninger");
        } else {
            System.out.println("Aapninger:");
            for (int[] aapning : aapninger) {
                System.out.println("(" + aapning[0] + ", " + aapning[1] + ")");
            }
        }
        aapninger.clear();
    }

    public void leggTilAapning(int rad, int kol) {
        int[] aapning = {rad, kol};
        aapninger.add(aapning);
    }

    @Override
    public String toString() {
        String streng = "";
        for (int i=0; i<antRad; i++) {
            for (int j=0; j<antKol; j++) {
                streng += " " + ruter[i][j];
            }
            streng += "\n";
        }
        return streng;
    }
}