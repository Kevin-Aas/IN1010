import java.util.ArrayList;

public class KoSystem {
    private static int antallLapper = 0;
    private ArrayList<KoLapp> koLapper = new ArrayList<KoLapp>();

    public void trekkKoLapp(){
        KoLapp nyKoLapp = new KoLapp(antallLapper+1);
        System.out.println("Du har faat tildelt billettnr. " + nyKoLapp.hentNummer());
        koLapper.add(nyKoLapp);
        antallLapper++;
        System.out.println("Det staar " + (koLapper.size()-1) + " foran deg");
        System.out.println();
    }

    public void betjenKunde(){
        if (koLapper.isEmpty()){
            System.out.println("Ingen er i ko");
        } else {
            KoLapp kunde = koLapper.get(0);
            System.out.println("Kunde med billettnr. " + kunde.hentNummer() + " er betjent.");
            System.out.println();
            koLapper.remove(0);
        }

    }

    public int antKunder(){
        return koLapper.size();
    }

    public void printKunderIKo(){
        System.out.println("Det staar " + antKunder() + " personer i ko.");
        System.out.println();
    }
    
}