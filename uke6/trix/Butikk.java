public class Butikk {
    private Person forste;

    public void entreButikk(Person p) {
        forste = p;
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
}
