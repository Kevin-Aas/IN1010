import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Studentsystem {
    public static void main(String[] args){
        System.out.println("** Velkommen til studentsystemet **");
        Scanner terminal = new Scanner(System.in);

        System.out.print("Vennligst oppgi navn på fil: ");
        String filnavn = terminal.nextLine();

        Scanner filLeser = null;
        boolean lestFerdig = false;
        while(!lestFerdig){
            try {
                filLeser = new Scanner(new File(filnavn));
                lestFerdig = true;
            } catch (Exception e) {
                System.out.print("Fant ikke fil. Vennligst oppgi nytt navn: ");
                filnavn = terminal.nextLine();
            }
        }
        
        ArrayList<Fag> alleFag = new ArrayList<Fag>();
        ArrayList<Student> alleStudenter = new ArrayList<Student>();
        // For å holde styr på de ulike studentene
        ArrayList<String> alleNavn = new ArrayList<String>();
        
        while(filLeser.hasNextLine()){
            String linje = filLeser.nextLine();
            if (linje.charAt(0) == '*'){
                String fagkode = linje.replace("*", "");
                alleFag.add(new Fag(fagkode));
            } else {
                Fag gjeldendeFag = alleFag.get(alleFag.size()-1);
                String navn = linje;
                Student student = null;
                if (!alleNavn.contains(navn)){
                    alleNavn.add(navn);
                    student = new Student(navn);
                    alleStudenter.add(student);
                } else {
                    int index = alleNavn.indexOf(navn);
                    student = alleStudenter.get(index);
                }
                student.leggTilFag(gjeldendeFag);
                gjeldendeFag.leggTilStudent(student);
            }
        }
        filLeser.close();

        boolean status = true;
        while(status){
            System.out.println("Velg en av følgende operasjoner:");
            System.out.println("1 - Fag med flest studenter");
            System.out.println("2 - Student som tar flest fag");
            System.out.println("3 - Studenter som tar et gitt fag");
            System.out.println("4 - Fag en bestemt student tar");
            System.out.println("5 - Legg til nytt fag til student");
            System.out.println("6 - Fjern fag fra en student");
            System.out.println("7 - Legg til ny student");
            System.out.println("8 - Legg til nytt fag");
            System.out.println("9 - Avslutt program");
            System.out.print("Valg: ");
            String svar = terminal.nextLine();
            System.out.println("----");
            
            switch (svar) {
                case "1": 
                    int flestS = 0;
                    String fagMedFlest = "";
                    for (Fag fag : alleFag){
                        if (fag.antallStudener() > flestS){
                            fagMedFlest = fag.hentFagkode();
                            flestS = fag.antallStudener();
                        }
                    }
                    System.out.println("Faget " + fagMedFlest + 
                                    " har flest studenter med et antall på " + flestS + " studenter.");
                    break;
                case "2":
                    int flestF = 0;
                    ArrayList<Student> flestFagStudenter = new ArrayList<Student>();
                    for (Student student : alleStudenter){
                        if (student.antallFag() > flestF){
                            flestFagStudenter.clear();
                            flestFagStudenter.add(student);
                            flestF = student.antallFag();
                        } else if (student.antallFag() == flestF){
                            flestFagStudenter.add(student);
                        }
                    }
                    System.out.println("Følgende student(er) tar opp flest fag (som foreløpig tilsvarer " +
                                    flestF +  " fag):");
                    for (Student student : flestFagStudenter){
                        System.out.println(student.hentNavn());
                    }
                    break;
                case "3":
                    System.out.print("Velg hvilket fag (f.eks. MAT1100): ");
                    String fagSvar = terminal.nextLine();
                    for (Fag fag : alleFag){
                        if (fagSvar.equals(fag.hentFagkode())){
                            fag.skrivAlleStudenter();
                        }
                    }
                    break;
                case "4":
                    System.out.print("Vennligst oppgi navn på student: ");
                    String navnSvar = terminal.nextLine();
                    if (alleNavn.contains(navnSvar)){
                        int index = alleNavn.indexOf(navnSvar);
                        Student student = alleStudenter.get(index);
                        student.skrivAlleFag();
                    } else {
                        System.out.println("Fant ikke studenten.");
                    }
                    break;
                case "5":
                    System.out.print("Vennligst velg student: ");
                    String navnSvar2 = terminal.nextLine();
                    if (alleNavn.contains(navnSvar2)){
                        int index = alleNavn.indexOf(navnSvar2);
                        Student student = alleStudenter.get(index);
                        System.out.print("Vennligst velg fag (f.eks. MAT1100): ");
                        String fagSvar2 = terminal.nextLine();
                        for (Fag fag : alleFag){
                            if (fagSvar2.equals(fag.hentFagkode())){
                                student.leggTilFag(fag);
                                fag.leggTilStudent(student);
                            }
                        }
                    } else {
                        System.out.println("Fant ikke studenten.");
                    }
                    break;
                case "6":
                    System.out.print("Vennligst velg student: ");
                    String navnSvar3 = terminal.nextLine();
                    if (alleNavn.contains(navnSvar3)){
                        int index = alleNavn.indexOf(navnSvar3);
                        Student student = alleStudenter.get(index);
                        System.out.print("Vennligst velg fag (f.eks. MAT1100): ");
                        String fagSvar2 = terminal.nextLine();
                        for (Fag fag : alleFag){
                            if (fagSvar2.equals(fag.hentFagkode())){
                                student.fjernFag(fag);
                                fag.fjernStudent(student);
                            }
                        }
                    } else {
                        System.out.println("Fant ikke studenten.");
                    }
                    break;
                case "7":
                    System.out.print("Vennligst oppgi navnet på den nye studenten: ");
                    String navnSvar4 = terminal.nextLine();
                    Student student = new Student(navnSvar4);
                    alleStudenter.add(student);
                    alleNavn.add(navnSvar4);
                    System.out.println("'Student ble lagt til i systemet.'");
                    break;
                case "8":
                    System.out.print("Vennligst oppgi navnet på det nye faget: ");
                    String fagkodeSvar = terminal.nextLine();
                    Fag fag = new Fag(fagkodeSvar);
                    alleFag.add(fag);
                    System.out.println("'Faget ble lagt til i systemet.'");                    
                    break;
                case "9":
                    status = false;
                    System.out.print("Lagre systemet som: ");
                    String lagreFilNavn = terminal.nextLine();
                    skrivTilFil(alleStudenter, alleFag, lagreFilNavn);
                    break;
                default:
                    System.out.println("Vennligst prøv igjen");
                    break;
            }
            System.out.println("----");
        }

        terminal.close();
    }

    public static void skrivTilFil(ArrayList<Student> alleStudenter, 
                                   ArrayList<Fag> alleFag,
                                   String filnavn){
        PrintWriter utfil = null; 
        try {
            utfil = new PrintWriter(filnavn);
        } catch (Exception e) {
            System.exit(0);
        }

        for (Fag fag : alleFag){
            utfil.println("*" + fag.hentFagkode());
            for (Student student : fag.hentStudenter()){
                utfil.println(student.hentNavn());
            }
        }
        utfil.close();
    }
}
