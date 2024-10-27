public class TestHester {

    public static void main(String[] args) {

        EngelskFullblodshest engelsk = new EngelskFullblodshest("Snorre", 32);
        PasoFino pasoFino = new PasoFino("Knut", 12);
        Islandshest islandsk = new Islandshest("Torrfinn", 22);

        engelsk.skritt();
        engelsk.trav();
        engelsk.galopp();

        pasoFino.toelt();

        islandsk.pass();
    }
}