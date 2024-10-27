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
            Node forrige = start;
            start = new Node(x);
            start.neste = forrige;
        }
    }

    public E taAv() {
        if (erTom()) {
            return null;
        }
        Node forrige = start;
        start = start.neste;
        return forrige.data;
    }

    public boolean erTom() {
        return (start == null);
    }
}
