import java.util.Scanner;

class MindreStorre {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Oppgi et tall: ");
        int x = scanner.nextInt();
        if (x < 20){
            if (x < 10){
                System.out.println("Dette tallet er mindre enn 10");
            } else {
                System.out.println("Dette tallet er mellom 10 og 20");
            }
        } else {
            System.out.println("Dette tallet er større enn 20");
        }
        scanner.close();
    }
}