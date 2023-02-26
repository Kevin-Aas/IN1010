public class Vanedannede extends Legemiddel{
    private static int antVanedannede = 0; // Holder styr paa antall objekter av denne klassen
    public final int id;
    public final int styrke;

    public Vanedannede(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
        // Setter id-en lik 'antall objekter som er laget foer denne instansen'
        // og oeker antall objekter lagd:
        id = antVanedannede;
        antVanedannede++;
    }

    public String toString() {
        return "--------------------------\n" +
               "Navn: " + navn + "\n" +
               "Pris: " + pris + " NOK\n" +
               "Virkestoff: " + virkestoff + " mg\n" + 
               "Styrke: " + styrke + "\n" + 
               "--------------------------";
    }
}
