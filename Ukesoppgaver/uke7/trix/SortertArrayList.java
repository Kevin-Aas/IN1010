import java.util.ArrayList;

public class SortertArrayList <T extends Comparable<T>> {
    
    ArrayList<T> liste = new ArrayList<>();

    public void settInn(T data) {
        int teller = 0;
        for (T element : liste) {
            if (element.compareTo(data) >= 0) {
                // element er mindre enn data
                T nydata = element;
                liste.set(teller, data);
                data = nydata;
                teller++;
            } else {
                teller++;
            }
        }
        liste.add(data);
    }

    public T hentUtFørste() {
        T første = liste.get(0);
        liste.remove(0);
        return første;
    }

}
