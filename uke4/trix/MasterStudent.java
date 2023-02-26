public class MasterStudent extends Student{
    boolean ekstraAdgang;

    public MasterStudent(String navn, int alder, String studie) {
        super(navn, alder, studie);
        this.ekstraAdgang = true;
    }

    public void skrivUt() {
        System.out.println("--------------");
        System.out.println("Navn: " + navn + "\n" +
                          "Alder: " + alder + "\n" +
                          "Studie: " + studie + " - " + "Master");
        System.out.println("--------------");
    }

    public boolean harTilgang() {
        return ekstraAdgang;
    }
}