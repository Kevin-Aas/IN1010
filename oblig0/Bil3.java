public class Bil3 {

    String bilNum;
    
    public Bil3(String bilnummer){
        bilNum = bilnummer;
    }

    public void bilMelding(){
        System.out.println("Jeg er en bil med bilnummer " + bilNum);
    }

    public String hentNummer(){
        return bilNum;
    }
}