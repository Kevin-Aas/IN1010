public class Stabel <E> extends Lenkeliste <E> {
    @Override
    public void leggTil(E x) {
        // Siste som blir lagt til blir til FØRSTE i lenke-listen
        if (antElementer == 0) {
            start = new Node(x);
        } else {
            Node siste = start;
            start = new Node(x);
            start.neste = siste;
        }
        antElementer++;
    }
}
