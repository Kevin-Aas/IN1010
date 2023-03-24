public class DobbelLenke<T> {
    private class Node {
        T data;
        Node neste;
        Node forrige;

        Node(T data) {
            this.data = data;
        }
    }
    Node forste;

    public void settInn(T element) {
        if (forste == null) {
            forste = new Node(element);
        } else {
            Node midlertidig = forste;
            while (midlertidig.neste != null) {
                midlertidig = midlertidig.neste;
            }
            midlertidig.neste = new Node(element);
            midlertidig.neste.forrige = midlertidig;
        }
    }
}
