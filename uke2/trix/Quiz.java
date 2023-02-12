import java.lang.Math;

class Quiz {
    public static void main(String[] args){
        Student student1 = new Student("Joakim");
        Student student2 = new Student("Kristin");
        Student student3 = new Student("Dag");
        Student[] studenter = {student1, student2, student3};

        int runtime = 20;
        for (int i=0; i<runtime; i++){
            for (Student student : studenter){
                if (Math.random() < 0.5){
                    student.leggTilQuizScore(1);
                } else {
                    student.leggTilQuizScore(0);
                }
            }
        }

        for (Student student : studenter){
            System.out.println(student.hentNavn() + ":");
            System.out.println("Total score = " + student.hentTotalScore());
            System.out.println("Snitt score = " + student.hentGjennomsnittligScore());
        }
    }
}