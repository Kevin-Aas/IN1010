public class GeneriskStabel <E> {
    protected class Node {
        Node neste = null;
        E data;
        Node (E x) {  // Konstruktør av indre klasse
            data = x;
        }
    }
    protected Node start;

    public void leggPaa(E x) {
        if (erTom()) {
            start = new Node(x);
        } else {
            Node gjeldende = start;
            start = new Node(x);
            start.neste = gjeldende;
        }
    }

    public E taAv() {
        if (erTom()) {
            return null;
        }
        Node gjeldende = start;
        start = start.neste;
        return gjeldende.data;
    }

    public boolean erTom() {
        return (start == null);
    }
}
