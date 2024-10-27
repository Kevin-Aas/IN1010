public class Professor extends Forsker {
    String kurs;

    public Professor(String navn, int alder, int lønnstrinn, String fagOmråde, String kurs) {
        super(navn, alder, lønnstrinn, fagOmråde);
        this.kurs = kurs;
    }

    public void skrivUt() {
        System.out.println("--------------");
        System.out.println("Navn: " + navn + "\n" +
                          "Alder: " + alder + "\n" +
                          "Lønnstrinn: " + lønnstrinn + "\n" +
                          "Fagområde: " + fagOmråde + "\n" + 
                          "Underviser: " + kurs);
        System.out.println("--------------");
    }
}