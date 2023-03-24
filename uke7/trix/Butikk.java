import java.util.Iterator;

public class Butikk implements Iterable<Person>{
    private Person forste;

    public void entreButikk(Person p) {
        if (forste == null) {
            forste = p;
        } else {
            Person midlertidig = forste;
            while (midlertidig.hentNeste() != null) {
                midlertidig = midlertidig.hentNeste();
            }
            midlertidig.settNeste(p);
        }
    }

    public void kassa() {
        while (forste != null) {
            System.out.println(forste.hentNavn() + " kjøper " +
                                 forste.hentGjenstand() + ".");
            System.out.println("- Hade bra!");
            forste = forste.hentNeste();
        }
        System.out.println("Ingen flere kunder. Vi stenger butikken for i dag");
    }

    @Override
    public PersonIterator iterator() {
        return new PersonIterator();
    }

    class PersonIterator implements Iterator<Person> {
        @Override
        public boolean hasNext() {
            return (forste != null);
        }

        @Override
        public Person next() {
            Person midlertidig = forste;
            forste = forste.hentNeste();
            return midlertidig;
        }
    }
}
