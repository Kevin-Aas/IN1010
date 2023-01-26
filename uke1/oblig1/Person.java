public class Person {

    String persNavn;
    String bilNum;

    public Person(String navn, String bilnummer){
        persNavn = navn;
        bilNum = bilnummer;
    }

    public void personMelding(){
        System.out.println(persNavn + " sin bil har bilnummer " + bilNum);
    }
}