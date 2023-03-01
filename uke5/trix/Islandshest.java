public class Islandshest extends Hest implements KanToelte, KanPasse {
    
    public Islandshest(String navn, int alder) {
        super(navn, alder);
    }

    public void toelt() {
        System.out.println(navn + " skritter i raskt tempo, med hevede bein.");
    }

    public void pass() {
        System.out.println(navn + " ser ut som den svever.");
    }
}