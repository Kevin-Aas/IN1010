public class TestBeholder {
    
    public static void main(String[] args) {

        Beholder<Sirkel> sirkelBeholder = new Beholder<Sirkel>();

        sirkelBeholder.settInn(new Sirkel(5));
        // sirkelBeholder.settInn(new Kvadrat(4)); gir feilmelding
    }
}
