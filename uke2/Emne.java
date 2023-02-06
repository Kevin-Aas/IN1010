class Emne {
    private String emnekode;
    private int maxAntallStudenter;
    public Student[] studenter;
    private int antallStudenter = 0;

    public Emne(String emnekode, int maxAntallStudenter){
        this.emnekode = emnekode;
        this.maxAntallStudenter = maxAntallStudenter;
        studenter = new Student[maxAntallStudenter];
    }
    
    public String hentEmnekode(){
        return emnekode;
    }

    public boolean harLedigPlass(){
        return maxAntallStudenter > antallStudenter;
    }

    public void leggTilStudenter(Student student){
        if (harLedigPlass()){
            studenter[antallStudenter] = student;
            System.out.println("["+student.hentId()+", "+student.hentNavn()+"]"+
                            " lagt til i "+emnekode);
            antallStudenter++;
        } else{
            System.out.println(emnekode + " er fullt!");
        }
    }
}