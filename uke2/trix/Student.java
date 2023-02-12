class Student {
    String navn;
    double quizScore = 0;
    int antQuizer;

    public Student(String navn){
        this.navn = navn;
    }

    public String hentNavn(){
        return navn;
    }

    public void leggTilQuizScore(int score){
        quizScore += score;
        antQuizer++;
    }

    public double hentTotalScore(){
        return quizScore;
    }

    public double hentGjennomsnittligScore(){
        double snitt = quizScore/antQuizer;
        return snitt;
    }
}