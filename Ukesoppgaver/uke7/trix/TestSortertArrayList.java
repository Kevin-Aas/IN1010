public class TestSortertArrayList {
    
    public static void main(String[] args) {
        Katt katt1 = new Katt("Ole", 3);
        Katt katt2 = new Katt("Neko", 5);
        Katt katt3 = new Katt("Franz", 6);
        Katt katt4 = new Katt("Luffy", 12);

        SortertArrayList<Katt> sortertKatteListe = new SortertArrayList<>();

        sortertKatteListe.settInn(katt1);
        sortertKatteListe.settInn(katt4);
        sortertKatteListe.settInn(katt2);
        sortertKatteListe.settInn(katt3);

        for (int i=0; i<4; i++) {
            System.out.println(sortertKatteListe.hentUtFørste());
        }

        Integer tall1 = 0;
        Integer tall2 = 1;
        Integer tall3 = 2;
        Integer tall4 = 3;

        SortertArrayList<Integer> tallListe = new SortertArrayList<>();

        tallListe.settInn(tall4);
        tallListe.settInn(tall3);
        tallListe.settInn(tall2);
        tallListe.settInn(tall1);

        for (int i=0; i<4; i++) {
            System.out.println(tallListe.hentUtFørste());
        }

    }
}
