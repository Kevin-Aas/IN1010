import java.util.Iterator;

abstract class Lenkeliste <E> implements Liste <E> {
    protected class Node {
        Node neste = null;
        E data;
        Node (E x) {
            data = x;
        }
    }
    protected Node start = null;

    protected int antElementer = 0;

    @Override
    public int stoerrelse() {
        return antElementer;
    }

    @Override
    public void leggTil(E x) {
        // Siste som blir lagt til blir til SISTE i lenke-listen
        if (antElementer == 0) {
            start = new Node(x);
        } else {
            Node siste = start;
            while (siste.neste != null) {
                siste = siste.neste;
            }
            siste.neste = new Node(x);
        }
        antElementer++;
    }

    @Override
    public E hent() {
        // Henter første fra lenke-listen:
        return start.data;
    }

    @Override
    public E fjern() {
        // Kaster feilmelding hvis man prøver å fjerne
        // fra er en tom lenke-liste:
        if (antElementer == 0) {
            throw new UgyldigListeindeks(-1);           // HUSKHUSK Å ENDRE!!!!!!!
        }
        // Henter første fra lenke-listen
        // og setter neste element som første i listen:
        Node gammelStart = start;
        start = start.neste;
        antElementer--;
        return gammelStart.data;
    }

    @Override
    public String toString() {
        String svar = "";
        Node sjekk = start;
        while (sjekk.neste != null) {
            svar += "(" + sjekk.data + ")";
            sjekk = sjekk.neste;
        }
        svar += "(" + sjekk.data + ")";
        return svar;
    }

    @Override
    public LenkelisteIterator iterator() {
        return new LenkelisteIterator();
    }

    class LenkelisteIterator implements Iterator<E> {
        Node iNode = start;

        @Override
        public boolean hasNext() {
            return iNode != null;
        }
    
        int teller = 0;
        @Override
        public E next() {
            while (teller < antElementer) {
                Node midlertidig = iNode;
                iNode = iNode.neste;
                teller++;
                return midlertidig.data;
            }
            return iNode.data;
        }
    }
}
