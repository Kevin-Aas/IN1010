public class TestGraadigBeholder {
    
    public static void main(String[] args) {

        Katt katt1 = new Katt("Ole", 3);
        Katt katt2 = new Katt("Neko", 5);
        Katt katt3 = new Katt("Franz", 6);

        GraadigBeholder<Katt> beholder = new GraadigBeholder<>();

        beholder.settInn(katt1);
        beholder.settInn(katt3);
        beholder.settInn(katt2);
        beholder.settInn(new Katt("Harald", 12));

        System.out.println(beholder.hent());
    }
}
