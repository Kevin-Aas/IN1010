import java.util.Iterator;

public class EnkelArrayListe implements Iterable<String>{
    String[] liste;

    public EnkelArrayListe(int storrelse) {
        liste = new String[storrelse];
    }

    public void leggTil(String element) {
        for (int i=0; i<liste.length; i++) {
            if (liste[i] == null) {
                liste[i] = element;
                return;
            }
        }
        System.out.println("Listen er full!");
    }

    @Override
    public Iterator<String> iterator() {
        return new ListeIterator();
    }

    class ListeIterator implements Iterator<String> {
        @Override
        public boolean hasNext() {
            return pos < liste.length;
        }

        private int pos = 0;
        @Override
        public String next() {
            pos++;
            return liste[pos-1];
        }
    }
}
