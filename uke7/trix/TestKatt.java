import java.util.ArrayList;

public class TestKatt {
    
    public static void main(String[] args) {
        
        ArrayList<Katt> katteListe = new ArrayList<>();

        katteListe.add(new Katt("Ole", 3));
        katteListe.add(new Katt("Neko", 5));
        katteListe.add(new Katt("Franz", 6));
        katteListe.add(new Katt("Simba", 2));
        katteListe.add(new Katt("Emma", 4));

        Katt eldstKatt = katteListe.get(0);
        for (Katt katt : katteListe) {
            if (katt.compareTo(eldstKatt) > 0) {
                eldstKatt = katt;
            }
        }
        String navn = eldstKatt.hentNavn();
        int alder = eldstKatt.hentAlder();
        System.out.println("Den eldste katte er "+navn+", som er "+alder+" år gammel.");
    }
}
