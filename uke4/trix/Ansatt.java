public abstract class Ansatt extends Person {
    int lønnstrinn;

    public Ansatt(String navn, int alder, int lønnstrinn) {
        super(navn, alder);
        this.lønnstrinn = lønnstrinn;
    }
}