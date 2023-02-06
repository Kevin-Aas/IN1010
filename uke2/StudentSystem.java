import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

class StudentSystem {
    private Emne[] emner;
    private HashMap<Integer, Student> studenter;
    private String filnavn;
    private static int idTeller = 0;
    
    public StudentSystem(Emne[] emner, String filnavn){
        this.emner = emner;
        this.filnavn = filnavn;
        studenter = new HashMap<Integer, Student>();
    }

    public void lesFraFil(){
        Scanner sc = null;
        try {
            File fil = new File(filnavn);
            sc = new Scanner(fil);
        } catch (Exception e) {
            System.out.println("Fant ikke fil");
        }

        while (sc.hasNextLine()){
            String navn = sc.nextLine().trim();
            int id = idTeller;     
            Student student = new Student(navn, id);
            studenter.put(id, student);
            
            idTeller++;
        }
    }

    public void skrivUtStudenter(){
        for (Integer id : studenter.keySet()){
            Student student = studenter.get(id);
            System.out.println(id + ": " + student.hentNavn());
        }
    }

    public void fyllOppEmner(){
        for (Integer id : studenter.keySet()){
            Student student = studenter.get(id);
            for (Emne emne : emner){
                emne.leggTilStudenter(student);
            }
        }
    }
}