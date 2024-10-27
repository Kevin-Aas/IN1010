public abstract class Student extends Person{
    String studie;

    public Student(String navn, int alder, String studie) {
        super(navn, alder);
        this.studie = studie;
    }

    public abstract boolean harTilgang();
}