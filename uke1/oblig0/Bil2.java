public class Bil2 {

    String bilNum;
    
    public Bil2(String bilnummer){
        bilNum = bilnummer;
    }

    public void bilMelding(){
        System.out.println("Jeg er en bil med bilnummer " + bilNum);
    }
}