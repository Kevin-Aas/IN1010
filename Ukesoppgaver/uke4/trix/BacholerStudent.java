public class BacholerStudent extends Student{
    boolean ekstraAdgang;

    public BacholerStudent(String navn, int alder, String studie) {
        super(navn, alder, studie);
        this.ekstraAdgang = false;
    }

    public void skrivUt() {
        System.out.println("--------------");
        System.out.println("Navn: " + navn + "\n" +
                          "Alder: " + alder + "\n" +
                          "Studie: " + studie + " - " + "Bacholer");
        System.out.println("--------------");
    }

    public boolean harTilgang() {
        return ekstraAdgang;
    }
}