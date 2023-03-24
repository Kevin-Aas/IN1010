public class GraadigBeholder <E extends Comparable<E>> {
    private E element;

    public E settInn(E element) {
        if (this.element == null) {
            this.element = element;
            return null;
        } else {
            if (this.element.compareTo(element) > 0) {
                // Det nye elementet er mindre enn det gamle
                return null;
            } else {
                // Det nye elementet er større eller lik enn det gamle
                E gamleElement = this.element;
                this.element = element;
                return gamleElement;
            }
        }
    }

    public E hent() {
        return element;
    }
}
