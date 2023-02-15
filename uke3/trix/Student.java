import java.util.ArrayList;

public class Student {
    private String navn;
    private ArrayList<Fag> fagOppmeldt = new ArrayList<Fag>();

    public Student(String navn){
        this.navn = navn;
    }

    public void leggTilFag(Fag fag){
        if (!fagOppmeldt.contains(fag)){    // Hvis studenten ikke er meldt opp i faget
            fagOppmeldt.add(fag);
        } else {
            System.out.println("["+navn + " er allerde meldt opp i " + fag.hentFagkode()+"]");
        }
    }

    public void fjernFag(Fag fag){
        if (fagOppmeldt.contains(fag)){
            fagOppmeldt.remove(fag);
        } else {
            System.out.println("["+navn + " er ikke meldt opp i " + fag.hentFagkode()+"]");
        }
    }

    public String hentNavn(){
        return navn;
    }

    public int antallFag(){
        return fagOppmeldt.size();
    }

    public void skrivAlleFag(){
        System.out.println("Alle fag som " + navn + " tar:");
        for (Fag fag : fagOppmeldt){
            System.out.print(fag.hentFagkode() + "  ");
        }
        System.out.println();
    }


}