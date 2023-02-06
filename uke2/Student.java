import java.util.ArrayList;

class Student {
    private String navn;
    private int studentId;
    private ArrayList<Emne> emner = new ArrayList<Emne>();

    public Student(String navn, int studentId){
        this.navn = navn;
        this.studentId = studentId;
    }

    public String hentNavn(){
        return navn;
    }

    public int hentId(){
        return studentId;
    }

    public void skrivUtEmner(){
        for (Emne emne : emner){
            System.out.println(emne.hentEmnekode());
        }
    }

    public void leggTilEmne(Emne emne){
        emner.add(emne);
    }

    public void fjernEmne(Emne emne){
        emner.remove(emne);
    }
}