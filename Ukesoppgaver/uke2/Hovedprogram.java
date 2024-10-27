class Hovedprogram {
    public static void main(String[] args){
        // Student student1 = new Student("Kevin", 15402);

        // System.out.println("Studentens navn: " + student1.hentNavn());
        // System.out.println("Studentens id: "+ student1.hentId());

        Emne emne1 = new Emne("IN1010", 80);
        Emne emne2 = new Emne("IN1030", 50);
        Emne[] emner = {emne1, emne2};

        StudentSystem studentSystem = new StudentSystem(emner, "studentnavn.csv");
        studentSystem.lesFraFil();
        //studentSystem.skrivUtStudenter();
        studentSystem.fyllOppEmner();
    }
}