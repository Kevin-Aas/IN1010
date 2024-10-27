import java.util.ArrayList;

public class Fag {
    private String fagkode;
    private ArrayList<Student> oppmeldteStudenter = new ArrayList<Student>();

    public Fag(String fagkode){
        this.fagkode = fagkode;
    }

    public void leggTilStudent(Student student){
        if (!oppmeldteStudenter.contains(student)){
            oppmeldteStudenter.add(student);
        } else {
            System.out.println("[" + student.hentNavn() + " er allerde meldt opp " + fagkode + "]");
        }
    }

    public void fjernStudent(Student student){
        if (oppmeldteStudenter.contains(student)){
            oppmeldteStudenter.remove(student);
        } else {
            System.out.println("[" + student.hentNavn() + " er allerde meldt opp i " + fagkode + "]");
        }
    }

    public String hentFagkode(){
        return fagkode;
    }

    public int antallStudener(){
        return oppmeldteStudenter.size();
    }

    public void skrivAlleStudenter(){
        System.out.println("Studenter meldt opp i " + fagkode + ":");
        for (Student student : oppmeldteStudenter){
            System.out.println(student.hentNavn());
        }
    }

    public ArrayList<Student> hentStudenter(){
        return oppmeldteStudenter;
    }
}