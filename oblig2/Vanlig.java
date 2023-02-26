public class Vanlig extends Legemiddel {
    private static int antVanlig = 0; // Holder styr paa antall objekter av denne klassen
    public final int id;
    
    public Vanlig(String navn, int pris, double virkestoff) {
        super(navn, pris, virkestoff);
        // Setter id-en lik 'antall objekter som er laget foer denne instansen'
        // og oeker antall objekter lagd:
        id = antVanlig;
        antVanlig++;
    }

}