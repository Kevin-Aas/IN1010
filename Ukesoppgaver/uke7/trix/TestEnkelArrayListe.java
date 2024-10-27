public class TestEnkelArrayListe {
    
    public static void main(String[] args) {

        EnkelArrayListe liste = new EnkelArrayListe(3);

        liste.leggTil("Hello");
        liste.leggTil("World");
        liste.leggTil("!");
        liste.leggTil("Test!");

        for (String element : liste) {
            System.out.println(element);
        }
        // Dette funker så listen er itererbar!
    }
}
