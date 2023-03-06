public class Parkeringsplass <E> {
    private E kjoretoy;

    public void parker(E kjoretoy) {
        this.kjoretoy = kjoretoy;
    }

    public E kjorUt() {
        E hentetKjortoy = kjoretoy;
        kjoretoy = null;
        return hentetKjortoy;
    }
}
