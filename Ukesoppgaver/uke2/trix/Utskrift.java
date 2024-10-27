public class Utskrift {
    public static void main(String[] args){
        utskrift("Dette er en tekst");
        utskrift(5);
        utskrift(5, 5);
    }

    public static void utskrift(String tekst){
        System.out.println(tekst);
    }

    public static void utskrift(int tall){
        System.out.println(tall);
    }

    public static void utskrift(int tall1, int tall2){
        System.out.println(tall1 + tall2);
    }


}