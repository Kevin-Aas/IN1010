public class Forsker extends Ansatt {
    String fagOmråde;

    public Forsker(String navn, int alder, int lønnstrinn, String fagOmråde) {
        super(navn, alder, lønnstrinn);
        this.fagOmråde = fagOmråde;
    }

    public void skrivUt() {
        System.out.println("--------------");
        System.out.println("Navn: " + navn + "\n" +
                          "Alder: " + alder + "\n" +
                          "Lønnstrinn: " + lønnstrinn + "\n" +
                          "Fagområde: " + fagOmråde);
        System.out.println("--------------");
    }
}