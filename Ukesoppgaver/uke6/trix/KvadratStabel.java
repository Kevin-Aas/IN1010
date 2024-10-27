public class KvadratStabel {
    protected class Node {
        Node neste = null;
        Kvadrat data;
        Node (Kvadrat x) {  // Konstruktør av indre klasse
            data = x;
        }
    }
    protected Node start;

    public void leggPaa(Kvadrat x) {
        if (erTom()) {
            start = new Node(x);
        } else {
            Node gjeldende = start;
            start = new Node(x);
            start.neste = gjeldende;
        }
    }

    public Kvadrat taAv() {
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